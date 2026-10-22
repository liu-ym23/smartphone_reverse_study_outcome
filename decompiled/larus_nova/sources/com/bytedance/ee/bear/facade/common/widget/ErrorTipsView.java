package com.bytedance.ee.bear.facade.common.widget;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import com.larksuite.component.universe_design.notice.UDNotice;
import com.larus.nova.R;
import io.reactivex.Flowable;
import io.reactivex.disposables.CompositeDisposable;

/* JADX INFO: loaded from: classes16.dex */
public class ErrorTipsView extends UDNotice {

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final /* synthetic */ int f226477z = 0;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final CompositeDisposable f226478y;

    public static final enum TipsType extends Enum<TipsType> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ TipsType[] f226479a = null;
        public static final TipsType error = null;
        public static final TipsType normal = null;
        public static final TipsType warning = null;

        static {
            TipsType r100 = new TipsType("warning", 0);
            warning = r100;
            TipsType r101 = new TipsType("error", 1);
            error = r101;
            TipsType r102 = new TipsType("normal", 2);
            normal = r102;
            f226479a = new TipsType[]{r100, r101, r102};
        }

        public static TipsType[] values() {
            return (TipsType[]) f226479a.clone();
        }

        public static TipsType valueOf(String r100) {
            return (TipsType) r27.a.a(TipsType.class, r100);
        }

        public TipsType(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f226480a = null;

        static {
            int[] r100 = new int[TipsType.values().length];
            f226480a = r100;
            r100[TipsType.warning.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L10:
            f226480a[TipsType.error.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L12:
            f226480a[TipsType.normal.ordinal()] = 3;     // Catch: NoSuchFieldError -> L9
            return;
        }
    }

    public interface b {
        void onClick(String r100, String r101);
    }

    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f226481a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f226482b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f226483c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public String f226484d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public String f226485e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public String f226486f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public String f226487g;

        public c(boolean r100, String r101, String r102) {
            this.f226481a = r100;
            this.f226482b = r101;
            this.f226483c = r102;
        }
    }

    public static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f226488a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f226489b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f226490c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final TipsType f226491d;

        public d(String r100, String r101, String r102, TipsType r103) {
            this.f226488a = r100;
            this.f226489b = r101;
            this.f226490c = r102;
            this.f226491d = r103;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f226478y.clear();
    }

    public ErrorTipsView(Context r100) {
        this(r100, null);
    }

    public ErrorTipsView(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    public ErrorTipsView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f226478y = new CompositeDisposable();
        setIconButton(R.drawable.ud_icon_close_small_outlined);
    }

    public final void o6(final String r100, final String r110, final String r111, final b r112, final String r113) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(r110) == true) goto L9;
        this.f226478y.add(Flowable.just(r111).map(new j(r111, r110)).subscribe(new k(this, r111, r112, r100, r113), new l()));
        return;
    }
}
