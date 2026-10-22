package kr4;

import android.text.TextUtils;
import com.bytedance.ee.bear.bitable.cardview.GridViewLayoutType;
import com.bytedance.ee.bear.bitable.common.viewmodel.TableInfoViewModel;
import com.bytedance.ee.bear.bitable.core.infoarch.arch.SceneModel;
import com.bytedance.ee.bear.contract.d;
import com.bytedance.ee.bear.domain.BearUrl;
import com.bytedance.ee.docsdk.impl.base.DocumentType;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class b implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d f505705a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final BearUrl f505706b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TableInfoViewModel f505707c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Function0<SceneModel> f505708d;

    @Override // kr4.a
    public final String b() {
        TableInfoViewModel r100 = this.f505707c;
        if (r100 == null) goto L7;
        GridViewLayoutType r101 = r100.getGridViewLayoutType();
        if (r101 == null) goto L7;
        return r101.getTag();
    L7:
        return null;
    }

    @Override // kr4.a
    public final String c() {
        BearUrl r100 = this.f505706b;
        if (r100 != null) goto L5;
    L7:
        return "ERR";
    L5:
        if (TextUtils.isEmpty(r100.f222561b) == true) goto L7;
        return du5.b.g(this.f505706b.f222561b);
    }

    @Override // kr4.a
    public final String d() {
        int r100 = com.bytedance.ee.bear.bitable.core.usercomponent.d.f210603a;
        Intrinsics.checkNotNullParameter("ccm.bitable.native_card_view", "key");
        if (com.bytedance.ee.bear.bitable.core.usercomponent.b.d("ccm.bitable.native_card_view") == false) goto L5;
        return "native";
    L5:
        return "web";
    }

    @Override // kr4.a
    public final SceneModel e() {
        Function0<SceneModel> r100 = this.f505708d;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.invoke();
    }

    @Override // kr4.a
    public final boolean f() {
        TableInfoViewModel r100 = this.f505707c;
        if (r100 != null) goto L7;
        return false;
    L7:
        return r100.isSyncTable();
    }

    public final String g() {
        BearUrl r100 = this.f505706b;
        if (r100 == null) goto L5;
        String r101 = r100.f222560a;
    L6:
        if (r101 != null) goto L8;
    L25:
        return "";
    L8:
        switch(r101.hashCode()) {
            case -102775833: goto L22;
            case 99640: goto L18;
            case 3649456: goto L15;
            case 109403487: goto L11;
            default: goto L25;
        };
    L11:
        if (r101.equals(DocumentType.SHEET_NAME) == false) goto L25;
        return "bitable_sheet_block";
    L15:
        if (r101.equals("wiki") == false) goto L25;
    L20:
        return "bitable_doc_block";
    L18:
        if (r101.equals("doc") == true) goto L20;
    L22:
        if (r101.equals(DocumentType.BITABLE_NAME) == false) goto L25;
        return "bitable_app";
    L5:
        r101 = null;
        goto L6
    }

    @Override // kr4.a
    public final String getDocType() {
        BearUrl r100 = this.f505706b;
        if (r100 != null) goto L5;
    L7:
        return "ERR";
    L5:
        if (TextUtils.isEmpty(r100.f222560a) == true) goto L7;
        return du5.b.g(this.f505706b.f222560a);
    }

    public final String h() {
        BearUrl r100 = this.f505706b;
        if (r100 == null) goto L6;
        String r101 = r100.f222560a;
        if (r101 == null) goto L6;
        return r101;
    L6:
        return "";
    }

    @Override // kr4.a
    public final d a() {
        return this.f505705a;
    }

    public b(d r100, BearUrl r101, TableInfoViewModel r102) {
        Intrinsics.checkNotNullParameter(r100, "analytic");
        this.f505705a = r100;
        this.f505706b = r101;
        this.f505707c = r102;
    }
}
