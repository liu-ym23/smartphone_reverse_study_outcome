package com.bytedance.ee.bear.facade.common.widget;

import android.content.Context;
import android.util.AttributeSet;
import com.larksuite.component.universe_design.notice.UDNotice;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes16.dex */
public class ForbiddenBannerView extends UDNotice {

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public a f226499y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public s f226500z;

    public static final enum ForbiddenState extends Enum<ForbiddenState> {
        public static final ForbiddenState COMPLAINT_APPEAL_RETURN = null;
        public static final ForbiddenState COMPLAINT_EXCEED_LIMITS = null;
        public static final ForbiddenState COMPLAINT_EXCEED_LIMITS_DAY = null;
        public static final ForbiddenState COMPLAINT_FAIL = null;
        public static final ForbiddenState COMPLAINT_SUCCESS = null;
        public static final ForbiddenState IN_COMPLAINT = null;
        public static final ForbiddenState WARNING = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ ForbiddenState[] f226501a = null;

        static {
            ForbiddenState r100 = new ForbiddenState("WARNING", 0);
            WARNING = r100;
            ForbiddenState r101 = new ForbiddenState("IN_COMPLAINT", 1);
            IN_COMPLAINT = r101;
            ForbiddenState r102 = new ForbiddenState("COMPLAINT_FAIL", 2);
            COMPLAINT_FAIL = r102;
            ForbiddenState r103 = new ForbiddenState("COMPLAINT_SUCCESS", 3);
            COMPLAINT_SUCCESS = r103;
            ForbiddenState r104 = new ForbiddenState("COMPLAINT_EXCEED_LIMITS_DAY", 4);
            COMPLAINT_EXCEED_LIMITS_DAY = r104;
            ForbiddenState r105 = new ForbiddenState("COMPLAINT_EXCEED_LIMITS", 5);
            COMPLAINT_EXCEED_LIMITS = r105;
            ForbiddenState r110 = new ForbiddenState("COMPLAINT_APPEAL_RETURN", 6);
            COMPLAINT_APPEAL_RETURN = r110;
            f226501a = new ForbiddenState[]{r100, r101, r102, r103, r104, r105, r110};
        }

        public static ForbiddenState[] values() {
            return (ForbiddenState[]) f226501a.clone();
        }

        public static ForbiddenState valueOf(String r100) {
            return (ForbiddenState) r27.a.a(ForbiddenState.class, r100);
        }

        public ForbiddenState(String r100, int r101) {
            super(r100, r101);
        }
    }

    public interface a {
        void B6();

        void f5();

        void q8();

        void s2();
    }

    public void C6() {
        Z5();
        setType(UDNotice.Type.ERROR);
        setIconColorful(true);
        setIcon(R.drawable.ud_icon_error_colorful);
        String r100 = getContext().getString(R.string.appealing_submit);
        String r101 = this.f226500z.c();
        int r102 = r101.indexOf(r100, 0);
        int r103 = r100.length() + r102;
        setText(r101);
        S5(r102, r103, new p(this));
        setVisibility(0);
    }

    public void H6() {
        Z5();
        setType(UDNotice.Type.WARNING);
        setIconColorful(true);
        setIcon(R.drawable.ud_icon_warning_colorful);
        String r100 = getContext().getString(R.string.appealing_submit);
        String r101 = this.f226500z.e();
        int r102 = r101.indexOf(r100, 0);
        int r103 = r100.length() + r102;
        setText(r101);
        S5(r102, r103, new q(this));
        setVisibility(0);
    }

    public void N6() {
        Z5();
        setType(UDNotice.Type.INFO);
        setIconColorful(true);
        setIcon(R.drawable.ud_icon_info_colorful);
        setText(this.f226500z.d());
        setVisibility(0);
    }

    public void s6() {
        Z5();
        setType(UDNotice.Type.ERROR);
        setIconColorful(true);
        setIcon(R.drawable.ud_icon_error_colorful);
        String r100 = getContext().getString(R.string.CreationMobile_ECM_Folder_SubmitMaximumToast2);
        String r101 = this.f226500z.b();
        int r102 = r101.indexOf(r100, 0);
        int r103 = r100.length() + r102;
        setText(r101);
        S5(r102, r103, new r(this));
        setVisibility(0);
    }

    public void u6() {
        Z5();
        setType(UDNotice.Type.ERROR);
        setIconColorful(true);
        setIcon(R.drawable.ud_icon_error_colorful);
        setText(this.f226500z.a());
        setVisibility(0);
    }

    public ForbiddenBannerView(Context r100) {
        this(r100, null);
    }

    public void setViewDelegate(a r100) {
        this.f226499y = r100;
    }

    public ForbiddenBannerView(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    public void o6(ForbiddenState r100, s r101) {
        this.f226500z = r101;
        if (r100 != ForbiddenState.WARNING) goto L6;
        H6();
        return;
    L6:
        if (r100 != ForbiddenState.IN_COMPLAINT) goto L9;
        N6();
        return;
    L9:
        if (r100 != ForbiddenState.COMPLAINT_FAIL) goto L12;
        C6();
        return;
    L12:
        if (r100 != ForbiddenState.COMPLAINT_EXCEED_LIMITS_DAY) goto L15;
        u6();
        return;
    L15:
        if (r100 != ForbiddenState.COMPLAINT_EXCEED_LIMITS) goto L17;
        s6();
        return;
    L17:
        setVisibility(8);
    }

    public ForbiddenBannerView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
    }
}
