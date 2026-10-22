package com.ss.android.lark.floating.widget.appfloat;

import android.view.View;
import android.view.WindowManager;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.ss.android.lark.floating.enums.SidePattern;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {2, 1, 0}, xi = 48)
final class TouchUtils$sideHideAnim$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ AppFloatManager.b $action;
    final /* synthetic */ boolean $notifyVc;
    final /* synthetic */ h $params;
    final /* synthetic */ View $view;
    final /* synthetic */ WindowManager $windowManager;
    final /* synthetic */ TouchUtils this$0;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f421933a = null;

        static {
            int[] r100 = new int[SidePattern.values().length];
            r100[SidePattern.RESULT_LEFT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r100[SidePattern.RESULT_RIGHT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r100[SidePattern.RESULT_HORIZONTAL.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            f421933a = r100;
        }
    }

    public TouchUtils$sideHideAnim$1(TouchUtils r100, h r101, View r102, WindowManager r103, AppFloatManager.b r104, boolean r105) {
        this.this$0 = r100;
        this.$params = r101;
        this.$view = r102;
        this.$windowManager = r103;
        this.$action = r104;
        this.$notifyVc = r105;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        TouchUtils r100 = this.this$0;
        h r101 = this.$params;
        View r102 = this.$view;
        int r103 = TouchUtils.f421901v;
        r100.f(r101, r102);
        TouchUtils r104 = this.this$0;
        r104.f421919r = true;
        r104.l();
        SidePattern r105 = this.this$0.f421903b.f554618m;
        int r106 = a.f421933a[r105.ordinal()];
        if (r106 != 1) goto L5;
        int r107 = this.this$0.d(this.$view);
    L15:
        TouchUtils r108 = this.this$0;
        h r109 = this.$params;
        r108.b(true, r109, r107, this.$windowManager, this.$view, this.$action, this.$notifyVc);
        return;
    L5:
        if (r106 != 2) goto L7;
        r107 = this.this$0.e();
        goto L15
    L7:
        if (r106 == 3) goto L9;
        return;
    L9:
        TouchUtils r110 = this.this$0;
        if (r110.f421909h >= r110.f421910i) goto L12;
        r107 = r110.d(this.$view);
        goto L15
    L12:
        r107 = r110.e();
        goto L15
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }
}
