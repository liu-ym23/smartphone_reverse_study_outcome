package hr4;

import android.content.Context;
import android.text.TextUtils;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.bitable.celleditor.BitableEditorPlugin;
import com.bytedance.ee.bear.bitable.celleditor.bean.EditorType;
import com.bytedance.ee.bear.bitable.celleditor.model.BitableEditorViewModel;
import com.bytedance.ee.bear.bitable.common.analytic.BitableAnalytic;
import com.bytedance.ee.bear.bitable.common.model.field.EFieldUIType;
import com.bytedance.ee.bear.document.DocViewModel;
import com.monitor.cloudmessage.consts.CloudControlInf;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final FragmentActivity f486859a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f486860b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final DocViewModel f486861c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final BitableAnalytic f486862d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final BitableEditorPlugin f486863e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Map<EditorType, com.bytedance.ee.bear.bitable.celleditor.editor.c<?>> f486864f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final List<com.bytedance.ee.bear.bitable.celleditor.editor.f> f486865g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public mr4.a f486866h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Function0<? extends ViewGroup> f486867i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Function0<BitableEditorViewModel> f486868j;

    /* JADX INFO: renamed from: hr4.a$a, reason: collision with other inner class name */
    public static final class C6186a {
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f486869a = null;

        static {
            int[] r100 = new int[EditorType.values().length];
            r100[EditorType.Rating.ordinal()] = 1;     // Catch: NoSuchFieldError -> L23
        L63:
            r100[EditorType.Phone.ordinal()] = 2;     // Catch: NoSuchFieldError -> L24
        L75:
            r100[EditorType.Date.ordinal()] = 3;     // Catch: NoSuchFieldError -> L25
        L47:
            r100[EditorType.Progress.ordinal()] = 4;     // Catch: NoSuchFieldError -> L26
        L51:
            r100[EditorType.Link.ordinal()] = 5;     // Catch: NoSuchFieldError -> L27
        L59:
            r100[EditorType.LinkTag.ordinal()] = 6;     // Catch: NoSuchFieldError -> L28
        L69:
            r100[EditorType.Select.ordinal()] = 7;     // Catch: NoSuchFieldError -> L29
        L55:
            r100[EditorType.Text.ordinal()] = 8;     // Catch: NoSuchFieldError -> L30
        L65:
            r100[EditorType.Chatter.ordinal()] = 9;     // Catch: NoSuchFieldError -> L31
        L67:
            r100[EditorType.Number.ordinal()] = 10;     // Catch: NoSuchFieldError -> L32
        L43:
            r100[EditorType.Location.ordinal()] = 11;     // Catch: NoSuchFieldError -> L33
        L61:
            r100[EditorType.Stage.ordinal()] = 12;     // Catch: NoSuchFieldError -> L34
        L73:
            r100[EditorType.Attachment.ordinal()] = 13;     // Catch: NoSuchFieldError -> L35
        L41:
            r100[EditorType.Url.ordinal()] = 14;     // Catch: NoSuchFieldError -> L36
        L53:
            r100[EditorType.Barcode.ordinal()] = 15;     // Catch: NoSuchFieldError -> L37
        L71:
            r100[EditorType.VoiceInput.ordinal()] = 16;     // Catch: NoSuchFieldError -> L38
        L45:
            r100[EditorType.TextAiPolish.ordinal()] = 17;     // Catch: NoSuchFieldError -> L39
        L49:
            r100[EditorType.Signature.ordinal()] = 18;     // Catch: NoSuchFieldError -> L40
        L21:
            f486869a = r100;
        }
    }

    static {
    }

    /* JADX WARN: Type inference failed for: r4v0, types: [com.bytedance.ee.bear.browser.plugin.PluginHost] */
    public final f a() {
        return new f(this.f486866h, this.f486861c, this.f486859a, this.f486863e.getHost(), true);
    }

    public final Context getContext() {
        return this.f486860b;
    }

    public final void b(String r100, Map<String, ? extends Object> r101, String r102) {
        EFieldUIType.Companion.getClass();
        EFieldUIType r103 = EFieldUIType.a.a(r100);
        if (TextUtils.isEmpty(r102) == false) goto L5;
        this.f486862d.B(r103, r101);
        return;
    L5:
        HashMap r104 = new HashMap();
        r104.put("field_type", r103.getReportValue());
        if (r101 != null) goto L8;
        r101 = MapsKt.emptyMap();
    L8:
        r104.putAll(r101);
        if (TextUtils.equals(r102, "EDIT_PANEL_SHOW") == false) goto L12;
        this.f486862d.t("ccm_bitable_field_input_mobile_view", r104);
        return;
    L12:
        if (TextUtils.equals(r102, "EDIT_PANEL_CLICK") == false) goto L17;
        this.f486862d.t("ccm_bitable_field_input_mobile_click", r104);
        return;
    }

    public a(FragmentActivity r100, Context r101, DocViewModel r102, BitableAnalytic r103, BitableEditorPlugin r104) {
        Intrinsics.checkNotNullParameter(r100, "mActivity");
        Intrinsics.checkNotNullParameter(r101, "mContext");
        Intrinsics.checkNotNullParameter(r102, "mDocViewModel");
        Intrinsics.checkNotNullParameter(r103, "mAnalytic");
        Intrinsics.checkNotNullParameter(r104, CloudControlInf.PLUGIN);
        this.f486859a = r100;
        this.f486860b = r101;
        this.f486861c = r102;
        this.f486862d = r103;
        this.f486863e = r104;
        this.f486864f = new LinkedHashMap();
        this.f486865g = new ArrayList();
    }
}
