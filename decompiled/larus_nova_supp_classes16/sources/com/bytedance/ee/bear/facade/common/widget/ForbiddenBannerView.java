package com.bytedance.ee.bear.facade.common.widget;

import android.content.Context;
import android.util.AttributeSet;
import com.larksuite.component.universe_design.notice.UDNotice;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class ForbiddenBannerView extends UDNotice {
    public a y;
    public s z;

    public static final enum ForbiddenState extends Enum<ForbiddenState> {
        public static final ForbiddenState COMPLAINT_APPEAL_RETURN = null;
        public static final ForbiddenState COMPLAINT_EXCEED_LIMITS = null;
        public static final ForbiddenState COMPLAINT_EXCEED_LIMITS_DAY = null;
        public static final ForbiddenState COMPLAINT_FAIL = null;
        public static final ForbiddenState COMPLAINT_SUCCESS = null;
        public static final ForbiddenState IN_COMPLAINT = null;
        public static final ForbiddenState WARNING = null;
        public static final /* synthetic */ ForbiddenState[] a = null;

        static {
            ForbiddenState r0 = new ForbiddenState("WARNING", 0);
            WARNING = r0;
            ForbiddenState r1 = new ForbiddenState("IN_COMPLAINT", 1);
            IN_COMPLAINT = r1;
            ForbiddenState r3 = new ForbiddenState("COMPLAINT_FAIL", 2);
            COMPLAINT_FAIL = r3;
            ForbiddenState r5 = new ForbiddenState("COMPLAINT_SUCCESS", 3);
            COMPLAINT_SUCCESS = r5;
            ForbiddenState r7 = new ForbiddenState("COMPLAINT_EXCEED_LIMITS_DAY", 4);
            COMPLAINT_EXCEED_LIMITS_DAY = r7;
            ForbiddenState r9 = new ForbiddenState("COMPLAINT_EXCEED_LIMITS", 5);
            COMPLAINT_EXCEED_LIMITS = r9;
            ForbiddenState r11 = new ForbiddenState("COMPLAINT_APPEAL_RETURN", 6);
            COMPLAINT_APPEAL_RETURN = r11;
            a = new ForbiddenState[]{r0, r1, r3, r5, r7, r9, r11};
        }

        public static ForbiddenState[] values() {
            return (ForbiddenState[]) a.clone();
        }

        public static ForbiddenState valueOf(String r1) {
            return (ForbiddenState) r27.a.a(ForbiddenState.class, r1);
        }

        public ForbiddenState(String r1, int r2) {
            super(r1, r2);
        }
    }

    public interface a {
        void B6();

        void f5();

        void q8();

        void s2();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void C6() {
        Z5();
        setType(UDNotice.Type.ERROR);
        setIconColorful(true);
        setIcon(2131254319);
        String r0 = getContext().getString(2131894314);
        String r1 = this.z.c();
        int r3 = r1.indexOf(r0, 0);
        int r2 = r0.length() + r3;
        setText(r1);
        S5(r3, r2, new p(this));
        setVisibility(0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void H6() {
        Z5();
        setType(UDNotice.Type.WARNING);
        setIconColorful(true);
        setIcon(2131256185);
        String r0 = getContext().getString(2131894314);
        String r1 = this.z.e();
        int r3 = r1.indexOf(r0, 0);
        int r2 = r0.length() + r3;
        setText(r1);
        S5(r3, r2, new q(this));
        setVisibility(0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void N6() {
        Z5();
        setType(UDNotice.Type.INFO);
        setIconColorful(true);
        setIcon(2131254918);
        setText(this.z.d());
        setVisibility(0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void s6() {
        Z5();
        setType(UDNotice.Type.ERROR);
        setIconColorful(true);
        setIcon(2131254319);
        String r0 = getContext().getString(2131887269);
        String r1 = this.z.b();
        int r3 = r1.indexOf(r0, 0);
        int r2 = r0.length() + r3;
        setText(r1);
        S5(r3, r2, new r(this));
        setVisibility(0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void u6() {
        Z5();
        setType(UDNotice.Type.ERROR);
        setIconColorful(true);
        setIcon(2131254319);
        setText(this.z.a());
        setVisibility(0);
    }

    public ForbiddenBannerView(Context r2) {
        this(r2, null);
    }

    public void setViewDelegate(a r1) {
        this.y = r1;
    }

    public ForbiddenBannerView(Context r2, AttributeSet r3) {
        this(r2, r3, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void o6(ForbiddenState r1, s r2) {
        this.z = r2;
        if (r1 != ForbiddenState.WARNING) goto L6;
        H6();
        return;
    L6:
        if (r1 != ForbiddenState.IN_COMPLAINT) goto L9;
        N6();
        return;
    L9:
        if (r1 != ForbiddenState.COMPLAINT_FAIL) goto L12;
        C6();
        return;
    L12:
        if (r1 != ForbiddenState.COMPLAINT_EXCEED_LIMITS_DAY) goto L15;
        u6();
        return;
    L15:
        if (r1 != ForbiddenState.COMPLAINT_EXCEED_LIMITS) goto L17;
        s6();
        return;
    L17:
        setVisibility(8);
    }

    public ForbiddenBannerView(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
    }
}
