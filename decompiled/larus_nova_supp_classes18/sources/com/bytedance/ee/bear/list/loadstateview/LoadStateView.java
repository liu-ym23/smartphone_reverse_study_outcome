package com.bytedance.ee.bear.list.loadstateview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.bytedance.ee.bear.facade.common.widget.BearLottieView;
import com.bytedance.ee.bear.widgets.universedesign.SpaceEmptyState;
import com.larksuite.component.universe_design.emptystate.UDEmptyState;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class LoadStateView extends FrameLayout {
    public e a;
    public b b;
    public d c;

    public static final enum CurrentViewType extends Enum<CurrentViewType> {
        public static final CurrentViewType EMPTY = null;
        public static final CurrentViewType LOADED_FAIL = null;
        public static final CurrentViewType LOADING = null;
        public static final CurrentViewType NONE = null;
        public static final /* synthetic */ CurrentViewType[] a = null;

        static {
            CurrentViewType r0 = new CurrentViewType("NONE", 0);
            NONE = r0;
            CurrentViewType r1 = new CurrentViewType("LOADING", 1);
            LOADING = r1;
            CurrentViewType r3 = new CurrentViewType("LOADED_FAIL", 2);
            LOADED_FAIL = r3;
            CurrentViewType r5 = new CurrentViewType("EMPTY", 3);
            EMPTY = r5;
            a = new CurrentViewType[]{r0, r1, r3, r5};
        }

        public static CurrentViewType[] values() {
            return (CurrentViewType[]) a.clone();
        }

        public static CurrentViewType valueOf(String r1) {
            return (CurrentViewType) r27.a.a(CurrentViewType.class, r1);
        }

        public CurrentViewType(String r1, int r2) {
            super(r1, r2);
        }
    }

    public interface a {
        void a();

        void b(View r1);

        void c();
    }

    public class b {
        public View a;
        public SpaceEmptyState b;
        public TextView c;
        public a d;
        public final /* synthetic */ LoadStateView e;

        public b(LoadStateView r1) {
            this.e = r1;
        }
    }

    public interface c {
        void a();
    }

    public class d {
        public SpaceEmptyState a;
        public c b;
        public final /* synthetic */ LoadStateView c;

        public d(LoadStateView r1) {
            this.c = r1;
        }
    }

    public class e {
        public FrameLayout a;
        public BearLottieView b;
        public LoadingCategory c;
        public final /* synthetic */ LoadStateView d;

        public e(LoadStateView r1) {
            this.d = r1;
        }

        public static void a(e r2) {
            FrameLayout r0 = r2.a;
            if (r0 == null) goto L8;
            r0.setVisibility(8);
            BearLottieView r3 = r2.b;
            if (r3 == null) goto L9;
            r3.cancelAnimation();
            return;
        L9:
            return;
        }
    }

    private FrameLayout.LayoutParams getChildLayoutParams() {
        FrameLayout.LayoutParams r0 = new FrameLayout.LayoutParams(-1, -2);
        r0.gravity = 17;
        return r0;
    }

    public final void b() {
        this.a = new e(this);
        this.b = new b(this);
        this.c = new d(this);
    }

    public LoadStateView(Context r1) {
        super(r1);
        CurrentViewType r2 = CurrentViewType.NONE;
        b();
    }

    public static /* synthetic */ FrameLayout.LayoutParams a(LoadStateView r0) {
        return r0.getChildLayoutParams();
    }

    @Override // android.view.View
    public void setVisibility(int r3) {
        super.setVisibility(r3);
        if (r3 == 4) goto L5;
        if (r3 == 8) goto L5;
        return;
    L5:
        CurrentViewType r4 = CurrentViewType.NONE;
        e.a(this.a);
        UDEmptyState r5 = this.c.a;
        if (r5 == null) goto L8;
        r5.setVisibility(8);
    L8:
        View r6 = this.b.a;
        if (r6 == null) goto L13;
        r6.setVisibility(8);
        return;
    }

    public LoadStateView(Context r1, AttributeSet r2) {
        super(r1, r2);
        CurrentViewType r3 = CurrentViewType.NONE;
        b();
    }

    public LoadStateView(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        CurrentViewType r4 = CurrentViewType.NONE;
        b();
    }
}
