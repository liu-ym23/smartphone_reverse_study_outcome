package com.bytedance.ee.bear.bitable.celleditor.editor;

import com.bytedance.ee.bear.bitable.celleditor.bean.CommonEditorModel;
import com.bytedance.ee.bear.bitable.celleditor.bean.EditorOperation;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public abstract class c<Model extends CommonEditorModel<?>> implements f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final hr4.a f209379a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public g<Model> f209380b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final com.bytedance.ee.bear.bitable.celleditor.editor.b f209381c;

    public static final class a {
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f209382a = null;

        static {
            int[] r100 = new int[EditorOperation.values().length];
            r100[EditorOperation.Open.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
        L15:
            r100[EditorOperation.Close.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
        L23:
            r100[EditorOperation.UpdatePatch.ordinal()] = 3;     // Catch: NoSuchFieldError -> L12
        L17:
            r100[EditorOperation.UpdateAll.ordinal()] = 4;     // Catch: NoSuchFieldError -> L13
        L19:
            r100[EditorOperation.NativeAction.ordinal()] = 5;     // Catch: NoSuchFieldError -> L14
        L8:
            f209382a = r100;
        }
    }

    static {
    }

    public abstract Class<Model> c();

    public abstract g<Model> d(Model r100);

    public void f(String r100, Model r101) {
        Intrinsics.checkNotNullParameter(r101, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
    }

    public com.bytedance.ee.bear.bitable.celleditor.editor.b e() {
        return this.f209381c;
    }

    public c(hr4.a r100) {
        Intrinsics.checkNotNullParameter(r100, "mEditorContext");
        this.f209379a = r100;
        this.f209381c = new com.bytedance.ee.bear.bitable.celleditor.editor.b();
    }

    @Override // com.bytedance.ee.bear.bitable.celleditor.editor.f
    public final void a(int r100) {
        g<Model> r101 = this.f209380b;
        if (r101 != null) goto L5;
        return;
    L5:
        if ((r101 instanceof f) == true) goto L7;
        return;
    L7:
        if ((r101 instanceof f) == false) goto L9;
        f r102 = (f) r101;
    L10:
        if (r102 == null) goto L15;
        r102.a(r100);
        return;
    L15:
        return;
    L9:
        r102 = null;
        goto L10
    }

    public static final void b(c r100, boolean r101) {
        hr4.a r102 = r100.f209379a;
        r102.getClass();
        Intrinsics.checkNotNullParameter(r100, "handler");
        ((ArrayList) r102.f486865g).remove(r100);
        g<Model> r103 = r100.f209380b;
        if (r103 == null) goto L5;
        r103.destroy();
    L5:
        r100.f209380b = null;
        if (r101 == false) goto L9;
        com.bytedance.ee.bear.bitable.celleditor.editor.b r104 = r100.e();
        int r105 = com.bytedance.ee.bear.bitable.celleditor.editor.b.f209378b;
        r104.d(false);
        return;
    }
}
