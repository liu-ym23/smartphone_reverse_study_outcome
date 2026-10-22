package com.bytedance.ee.bear.list.loadstateview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import com.bytedance.ee.bear.facade.common.widget.BearLottieView;
import com.bytedance.ee.bear.widgets.universedesign.SpaceEmptyState;

/* JADX INFO: loaded from: classes18.dex */
public class LoadStateView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public e f228621a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public b f228622b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public d f228623c;

    public static final enum CurrentViewType extends Enum<CurrentViewType> {
        public static final CurrentViewType EMPTY = null;
        public static final CurrentViewType LOADED_FAIL = null;
        public static final CurrentViewType LOADING = null;
        public static final CurrentViewType NONE = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ CurrentViewType[] f228624a = null;

        static {
            CurrentViewType r100 = new CurrentViewType(UserProfileEvent.POSITION_NONE, 0);
            NONE = r100;
            CurrentViewType r101 = new CurrentViewType("LOADING", 1);
            LOADING = r101;
            CurrentViewType r102 = new CurrentViewType("LOADED_FAIL", 2);
            LOADED_FAIL = r102;
            CurrentViewType r103 = new CurrentViewType("EMPTY", 3);
            EMPTY = r103;
            f228624a = new CurrentViewType[]{r100, r101, r102, r103};
        }

        public static CurrentViewType[] values() {
            return (CurrentViewType[]) f228624a.clone();
        }

        public static CurrentViewType valueOf(String r100) {
            return (CurrentViewType) r27.a.a(CurrentViewType.class, r100);
        }

        public CurrentViewType(String r100, int r101) {
            super(r100, r101);
        }
    }

    public interface a {
        void a();

        void b(View r100);

        void c();
    }

    public class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public View f228625a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public SpaceEmptyState f228626b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public TextView f228627c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public a f228628d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ LoadStateView f228629e;

        public b(LoadStateView r100) {
            this.f228629e = r100;
        }
    }

    public interface c {
        void a();
    }

    public class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public SpaceEmptyState f228630a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public c f228631b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ LoadStateView f228632c;

        public d(LoadStateView r100) {
            this.f228632c = r100;
        }
    }

    public class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public FrameLayout f228633a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public BearLottieView f228634b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public LoadingCategory f228635c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ LoadStateView f228636d;

        public e(LoadStateView r100) {
            this.f228636d = r100;
        }

        public static void a(e r100) {
            FrameLayout r101 = r100.f228633a;
            if (r101 == null) goto L8;
            r101.setVisibility(8);
            BearLottieView r102 = r100.f228634b;
            if (r102 == null) goto L9;
            r102.cancelAnimation();
            return;
        L9:
            return;
        }
    }

    private FrameLayout.LayoutParams getChildLayoutParams() {
        FrameLayout.LayoutParams r100 = new FrameLayout.LayoutParams(-1, -2);
        r100.gravity = 17;
        return r100;
    }

    public final void b() {
        this.f228621a = new e(this);
        this.f228622b = new b(this);
        this.f228623c = new d(this);
    }

    public LoadStateView(Context r100) {
        super(r100);
        CurrentViewType r101 = CurrentViewType.NONE;
        b();
    }

    public static /* synthetic */ FrameLayout.LayoutParams a(LoadStateView r100) {
        return r100.getChildLayoutParams();
    }

    @Override // android.view.View
    public void setVisibility(int r100) {
        super.setVisibility(r100);
        if (r100 == 4) goto L5;
        if (r100 == 8) goto L5;
        return;
    L5:
        CurrentViewType r101 = CurrentViewType.NONE;
        e.a(this.f228621a);
        SpaceEmptyState r102 = this.f228623c.f228630a;
        if (r102 == null) goto L8;
        r102.setVisibility(8);
    L8:
        View r103 = this.f228622b.f228625a;
        if (r103 == null) goto L13;
        r103.setVisibility(8);
        return;
    }

    public LoadStateView(Context r100, AttributeSet r101) {
        super(r100, r101);
        CurrentViewType r102 = CurrentViewType.NONE;
        b();
    }

    public LoadStateView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        CurrentViewType r103 = CurrentViewType.NONE;
        b();
    }
}
