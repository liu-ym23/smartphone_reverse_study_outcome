package com.bytedance.ee.bear.facade.common.widget;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import com.larksuite.component.universe_design.notice.UDNotice;
import io.reactivex.Flowable;
import io.reactivex.disposables.CompositeDisposable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class ErrorTipsView extends UDNotice {
    public static final /* synthetic */ int z = 0;
    public final CompositeDisposable y;

    public static final enum TipsType extends Enum<TipsType> {
        public static final /* synthetic */ TipsType[] a = null;
        public static final TipsType error = null;
        public static final TipsType normal = null;
        public static final TipsType warning = null;

        static {
            TipsType r0 = new TipsType("warning", 0);
            warning = r0;
            TipsType r1 = new TipsType("error", 1);
            error = r1;
            TipsType r3 = new TipsType("normal", 2);
            normal = r3;
            a = new TipsType[]{r0, r1, r3};
        }

        public static TipsType[] values() {
            return (TipsType[]) a.clone();
        }

        public static TipsType valueOf(String r1) {
            return (TipsType) r27.a.a(TipsType.class, r1);
        }

        public TipsType(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[TipsType.values().length];
            a = r0;
            r0[TipsType.warning.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L10:
            a[TipsType.error.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L12:
            a[TipsType.normal.ordinal()] = 3;     // Catch: NoSuchFieldError -> L9
            return;
        }
    }

    public interface b {
        void onClick(String r1, String r2);
    }

    public static class c {
        public final boolean a;
        public final String b;
        public final String c;
        public String d;
        public String e;
        public String f;
        public String g;

        public c(boolean r1, String r2, String r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }
    }

    public static class d {
        public final String a;
        public final String b;
        public final String c;
        public final TipsType d;

        public d(String r1, String r2, String r3, TipsType r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onDetachedFromWindow() {
        super/*android.view.ViewGroup*/.onDetachedFromWindow();
        this.y.clear();
    }

    public ErrorTipsView(Context r2) {
        this(r2, null);
    }

    public ErrorTipsView(Context r2, AttributeSet r3) {
        this(r2, r3, 0);
    }

    public ErrorTipsView(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        this.y = new CompositeDisposable();
        setIconButton(2131254124);
    }

    public final void o6(final String r9, final String r10, final String r11, final b r12, final String r13) {
        if (TextUtils.isEmpty(r9) == false) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(r10) == true) goto L9;
        this.y.add(Flowable.just(r11).map(new j(r11, r10)).subscribe(new k(this, r11, r12, r9, r13), new l()));
        return;
    }
}
