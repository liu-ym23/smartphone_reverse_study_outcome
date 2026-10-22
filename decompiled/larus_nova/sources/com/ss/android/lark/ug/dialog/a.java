package com.ss.android.lark.ug.dialog;

import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.squareup.wire.ProtoAdapter;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.pb.ug_reach.DialogMaterial;
import com.ss.android.lark.pb.ug_reach.MaterialBase;
import k9c.f;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class a extends l9c.a<DialogMaterial> {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ int f444437g = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ProtoAdapter<DialogMaterial> f444438f;

    /* JADX INFO: renamed from: com.ss.android.lark.ug.dialog.a$a, reason: collision with other inner class name */
    public static final class C5364a implements f<a> {
        public C5364a() {
        }

        @Override // k9c.f
        public final l9c.a a(String r100) {
            Intrinsics.checkNotNullParameter(r100, "reachPointId");
            return new a(r100);
        }
    }

    public static final class b {
    }

    @Override // k9c.d
    public final boolean onHide() {
        return false;
    }

    static {
        C5364a r100 = new C5364a();
        Intrinsics.checkNotNullParameter("Dialog", "reachPointType");
        Intrinsics.checkNotNullParameter(a.class, "reachPointClazz");
        Intrinsics.checkNotNullParameter(r100, "factory");
        l9c.a.f508137e.put(a.class, new l9c.a.b("Dialog", a.class, r100));
    }

    @Override // k9c.d
    public final MaterialBase a() {
        DialogMaterial r100 = (DialogMaterial) this.f508140c;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.mbase;
    }

    @Override // k9c.d
    public final void onCreate() {
        Log.i("UgReach_ug_dialog", WidgetCostModule.TYPE_ON_CREATE);
    }

    @Override // k9c.d
    public final void onDestroy() {
        Log.i("UgReach_ug_dialog", LiveCommonConstants.REASON_ON_DEDTROY);
    }

    @Override // k9c.d
    public final boolean onShow() {
        if (((DialogMaterial) this.f508140c) != null) goto L6;
        Log.e("UgReach_ug_dialog", "onShow, data is invalid");
        return false;
    L6:
        Log.e("UgReach_ug_dialog", "onShow, dialogData is invalid.");
        return false;
    }

    @Override // l9c.a
    public final ProtoAdapter<DialogMaterial> c() {
        return this.f444438f;
    }

    public a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "reachPointId");
        Intrinsics.checkNotNullParameter("Dialog", "reachPointType");
        super(r100, "Dialog");
        this.f444438f = DialogMaterial.ADAPTER;
    }
}
