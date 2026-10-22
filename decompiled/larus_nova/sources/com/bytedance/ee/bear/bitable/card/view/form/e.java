package com.bytedance.ee.bear.bitable.card.view.form;

import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.bitable.card.viewmodel.BitableCardViewModel;
import com.bytedance.ee.bear.bitable.share.sharepanel.FormsShareFragmentDelegate;
import com.bytedance.ee.bear.document.DocViewModel;
import com.bytedance.ee.docsdk.impl.base.DocumentType;
import java.util.WeakHashMap;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes15.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final WeakHashMap<DialogFragment, FormsShareFragmentDelegate> f208429a = null;

    public static final class a {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final /* synthetic */ int f208430g = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final FragmentActivity f208431a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final DocViewModel f208432b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final BitableCardViewModel f208433c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final BitableSharePlugin.FormsShareModel f208434d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final com.bytedance.ee.bear.share.export.e f208435e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final b f208436f;

        /* JADX INFO: renamed from: com.bytedance.ee.bear.bitable.card.view.form.e$a$a, reason: collision with other inner class name */
        public static final class C3007a {
        }

        static {
        }

        public final FragmentActivity getActivity() {
            return this.f208431a;
        }

        public a(FragmentActivity r100, DocViewModel r101, BitableCardViewModel r102, BitableSharePlugin.FormsShareModel r103, com.bytedance.ee.bear.share.export.e r104, b r105) {
            this.f208431a = r100;
            this.f208432b = r101;
            this.f208433c = r102;
            this.f208434d = r103;
            this.f208435e = r104;
            this.f208436f = r105;
        }
    }

    public interface b {
        void a(DialogFragment r100);

        void onError();
    }

    static {
        f208429a = new WeakHashMap();
    }

    @JvmStatic
    public static final String a(DocViewModel r100) {
        if (r100 == null) goto L25;
        String r101 = r100.getDocumentType();
        int r102 = r101.hashCode();
        if (r102 == (-102775833)) goto L20;
        if (r102 == 99640) goto L16;
        if (r102 == 109403487) goto L12;
        return "";
    L12:
        if (r101.equals(DocumentType.SHEET_NAME) == false) goto L27;
        String r103 = "bitable_sheet_block";
    L24:
        return r103;
    L27:
        return "";
    L16:
        if (r101.equals("doc") == false) goto L28;
        r103 = "bitable_doc_block";
        goto L24
    L28:
        return "";
    L20:
        if (r101.equals(DocumentType.BITABLE_NAME) == false) goto L29;
        r103 = "bitable_app";
        goto L24
    L29:
        return "";
    L25:
        return "";
    }
}
