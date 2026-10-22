package com.suite.lark.platform.component.widget_biz_tenantname;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.GravityCompat;
import com.byted.cast.common.CastMonitor;
import com.bytedance.lark.pb.basic.v1.TenantNameStatus;
import com.larksuite.framework.utils.UIUtils;
import com.larus.nova.R;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.suite.lark.platform.component.widget_biz_tenantname.data.TenantCertificationData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u0000 32\u00020\u0001:\u00013B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ\"\u0010 \u001a\u00020!2\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\t\u001a\u00020\nH\u0002J\u0006\u0010\u001d\u001a\u00020\u001eJ\u0010\u0010\"\u001a\u00020!2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cJ\b\u0010#\u001a\u00020!H\u0002J\b\u0010$\u001a\u00020!H\u0002J\u0010\u0010%\u001a\u00020!2\b\u0010&\u001a\u0004\u0018\u00010'J0\u0010(\u001a\u00020!2\u0006\u0010)\u001a\u00020\u001e2\u0006\u0010*\u001a\u00020\n2\u0006\u0010+\u001a\u00020\n2\u0006\u0010,\u001a\u00020\n2\u0006\u0010-\u001a\u00020\nH\u0014J\u0012\u0010.\u001a\u00020!2\b\u0010/\u001a\u0004\u0018\u000100H\u0002J\u0010\u00101\u001a\u00020!2\u0006\u00102\u001a\u00020\nH\u0002R\u001e\u0010\f\u001a\u0004\u0018\u00010\r8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001e\u0010\u0012\u001a\u0004\u0018\u00010\r8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u000f\"\u0004\b\u0014\u0010\u0011R\u001e\u0010\u0015\u001a\u0004\u0018\u00010\u00168FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u001eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u00064"}, d2 = {"Lcom/suite/lark/platform/component/widget_biz_tenantname/TenantNameTextView;", "Landroid/widget/FrameLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ivTenantNameFromXml", "Landroid/widget/TextView;", "getIvTenantNameFromXml", "()Landroid/widget/TextView;", "setIvTenantNameFromXml", "(Landroid/widget/TextView;)V", "ivTenantCertTagFromXml", "getIvTenantCertTagFromXml", "setIvTenantCertTagFromXml", "tenantNameContainerFromXml", "Landroid/widget/LinearLayout;", "getTenantNameContainerFromXml", "()Landroid/widget/LinearLayout;", "setTenantNameContainerFromXml", "(Landroid/widget/LinearLayout;)V", "tenantNameData", "Lcom/suite/lark/platform/component/widget_biz_tenantname/data/TenantNameData;", "hasValidTenantName", "", "isShowTenantCertification", "initCustomAttrs", "", "setTenantNameData", "checkTenantNameIsEllipse", "resetTenantName", "setTenantCertificationData", "certificationInfo", "Lcom/suite/lark/platform/component/widget_biz_tenantname/data/TenantCertificationData;", "onLayout", CastMonitor.EVENT_PARAM_BYTECAST_NETWORK_STATE_CHANGED, "left", "top", "right", "bottom", "setRealTenantName", "tenantName", "", "setEllipsize", "ellipsize", "Companion", "widget-biz-tenantname_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TenantNameTextView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TextView f461117a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public TextView f461118b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public LinearLayout f461119c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public gpc.a f461120d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f461121e;

    public static final class a {
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f461122a = null;

        static {
            int[] r100 = new int[TenantNameStatus.values().length];
            r100[TenantNameStatus.TENANT_NAME_STATUS_UNKNOWN.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r100[TenantNameStatus.TENANT_NAME_STATUS_HIDE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r100[TenantNameStatus.TENANT_NAME_STATUS_NOT_FRIEND.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r100[TenantNameStatus.TENANT_NAME_STATUS_VISIBLE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            f461122a = r100;
        }
    }

    static {
    }

    public final TextView getIvTenantCertTagFromXml() {
        KeyEvent.Callback r100 = this.f461118b;
        if (r100 != null) goto L6;
        r100 = findViewById(R.id.iv_tenant_cert_tag);
        this.f461118b = (TextView) r100;
    L6:
        return (TextView) r100;
    }

    public final TextView getIvTenantNameFromXml() {
        KeyEvent.Callback r100 = this.f461117a;
        if (r100 != null) goto L6;
        r100 = findViewById(R.id.iv_tenant_name);
        this.f461117a = (TextView) r100;
    L6:
        return (TextView) r100;
    }

    public final LinearLayout getTenantNameContainerFromXml() {
        KeyEvent.Callback r100 = this.f461119c;
        if (r100 != null) goto L6;
        r100 = findViewById(R.id.tenant_name_container);
        this.f461119c = (LinearLayout) r100;
    L6:
        return (LinearLayout) r100;
    }

    public TenantNameTextView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        FrameLayout.inflate(getContext(), R.layout.view_tenant_name, this);
    }

    private final void setEllipsize(int r100) {
        if (r100 != 1) goto L5;
        TextView r101 = getIvTenantNameFromXml();
        if (r101 == null) goto L30;
        r101.setEllipsize(TextUtils.TruncateAt.START);
        return;
    L30:
        return;
    L5:
        if (r100 != 2) goto L7;
        TextView r102 = getIvTenantNameFromXml();
        if (r102 == null) goto L28;
        r102.setEllipsize(TextUtils.TruncateAt.MIDDLE);
        return;
    L28:
        return;
    L7:
        if (r100 != 3) goto L9;
        TextView r103 = getIvTenantNameFromXml();
        if (r103 == null) goto L26;
        r103.setEllipsize(TextUtils.TruncateAt.END);
        return;
    L26:
        return;
    L9:
        if (r100 != 4) goto L31;
        TextView r104 = getIvTenantNameFromXml();
        if (r104 == null) goto L24;
        r104.setEllipsize(TextUtils.TruncateAt.MARQUEE);
        return;
    L24:
        return;
    }

    private final void setRealTenantName(String r100) {
        StringBuilder r101 = new StringBuilder("setRealTenantName chatterId:");
        gpc.a r102 = this.f461120d;
        String r103 = null;
        if (r102 == null) goto L5;
        String r104 = r102.f482145e;
    L6:
        r101.append(r104);
        r101.append(", tenantName isEmpty: ");
        gpc.a r105 = this.f461120d;
        if (r105 == null) goto L10;
        r103 = r105.f482141a;
    L10:
        if (r103 != null) goto L12;
    L15:
        boolean r106 = true;
    L16:
        r101.append(r106);
        Log.i("TenantName", r101.toString());
        if (r100 != null) goto L19;
    L22:
        boolean r107 = true;
    L23:
        if (r107 == true) goto L25;
        getIvTenantNameFromXml().setText(r100);
        this.f461121e = true;
        setVisibility(0);
        return;
    L25:
        setVisibility(8);
        return;
    L19:
        if (r100.length() == 0) goto L22;
        r107 = false;
        goto L23
    L12:
        if (r103.length() == 0) goto L15;
        r106 = false;
        goto L16
    L5:
        r104 = null;
        goto L6
    }

    public final void setIvTenantCertTagFromXml(TextView r100) {
        this.f461118b = r100;
    }

    public final void setIvTenantNameFromXml(TextView r100) {
        this.f461117a = r100;
    }

    public final void setTenantCertificationData(TenantCertificationData r100) {
        qqb.a.h("TenantName");     // Catch: Throwable -> L29
        if (this.f461121e == false) goto L26;
        if (r100 == null) goto L26;
        StringBuilder r101 = new StringBuilder("setTenantCertificationData chatterId:");     // Catch: Throwable -> L29
        gpc.a r102 = this.f461120d;     // Catch: Throwable -> L29
        if (r102 == null) goto L10;
        String r103 = r102.f482145e;     // Catch: Throwable -> L29
    L11:
        r101.append(r103);     // Catch: Throwable -> L29
        r101.append(", certificationInfo.isShowCertSign: ");     // Catch: Throwable -> L29
        r101.append(r100.f461123a);     // Catch: Throwable -> L29
        r101.append(", certificationInfo.CertificateStatus: ");     // Catch: Throwable -> L29
        r101.append(r100.f461124b);     // Catch: Throwable -> L29
        Log.i("TenantName", r101.toString());     // Catch: Throwable -> L29
        if (Intrinsics.areEqual(r100.f461123a, Boolean.TRUE) == false) goto L23;
        fpc.a r104 = new fpc.a(getContext());     // Catch: Throwable -> L29
        r104.f478396b = r100;     // Catch: Throwable -> L29
        SpannableStringBuilder r105 = r104.a();     // Catch: Throwable -> L29
        if (r105 != null) goto L16;
    L19:
        boolean r106 = true;
    L20:
        if (r106 == false) goto L22;
        getIvTenantCertTagFromXml().setVisibility(8);     // Catch: Throwable -> L29
    L24:
        qqb.a.a();
        return;
    L22:
        getIvTenantCertTagFromXml().setVisibility(0);     // Catch: Throwable -> L29
        getIvTenantCertTagFromXml().setText(r105);     // Catch: Throwable -> L29
        goto L24
    L16:
        if (r105.length() == 0) goto L19;
        r106 = false;
        goto L20
    L23:
        getIvTenantCertTagFromXml().setVisibility(8);     // Catch: Throwable -> L29
        goto L24
    L10:
        r103 = null;
    L26:
        getIvTenantCertTagFromXml().setVisibility(8);     // Catch: Throwable -> L29
        qqb.a.a();
        return;
    L29:
        th = move-exception;
        qqb.a.a();
        throw th;
    }

    public final void setTenantNameContainerFromXml(LinearLayout r100) {
        this.f461119c = r100;
    }

    public final void setTenantNameData(gpc.a r100) {
        qqb.a.h("TenantName");     // Catch: Throwable -> L45
        this.f461120d = r100;     // Catch: Throwable -> L45
        this.f461121e = false;     // Catch: Throwable -> L45
        if (r100 != null) goto L8;
        setVisibility(4);     // Catch: Throwable -> L45
        qqb.a.a();
        return;
    L8:
        getIvTenantCertTagFromXml().setVisibility(8);     // Catch: Throwable -> L45
        getIvTenantNameFromXml().invalidate();     // Catch: Throwable -> L45
        getIvTenantNameFromXml().requestLayout();     // Catch: Throwable -> L45
        TenantNameStatus r101 = r100.f482142b;     // Catch: Throwable -> L45
        if (r101 != null) goto L11;
    L42:
        setRealTenantName(r100.f482141a);     // Catch: Throwable -> L45
        qqb.a.a();
        return;
    L11:
        if (r100.f482144d == true) goto L42;
        if (r101 == TenantNameStatus.TENANT_NAME_STATUS_UNKNOWN) goto L42;
        StringBuilder r102 = new StringBuilder("setTenantNameData chatterId:");     // Catch: Throwable -> L45
        r102.append(r100.f482145e);     // Catch: Throwable -> L45
        r102.append(", tenantNameStatus:");     // Catch: Throwable -> L45
        r102.append(r100.f482142b);     // Catch: Throwable -> L45
        r102.append(", tenantName isEmpty: ");     // Catch: Throwable -> L45
        String r103 = r100.f482141a;     // Catch: Throwable -> L45
        if (r103 != null) goto L18;
    L21:
        boolean r104 = true;
    L22:
        r102.append(r104);     // Catch: Throwable -> L45
        Log.i("TenantName", r102.toString());     // Catch: Throwable -> L45
        TenantNameStatus r105 = r100.f482142b;     // Catch: Throwable -> L45
        if (r105 != null) goto L25;
        int r106 = -1;
    L26:
        if (r106 != 1) goto L28;
        setVisibility(4);     // Catch: Throwable -> L45
    L40:
        qqb.a.a();
        return;
    L28:
        if (r106 != 2) goto L30;
        setVisibility(0);     // Catch: Throwable -> L45
        getIvTenantNameFromXml().setText(UIUtils.getString(getContext(), R.string.Lark_IM_Profile_UserHideOrgInfo_Placeholder));     // Catch: Throwable -> L45
        goto L40
    L30:
        if (r106 == 3) goto L35;
        if (r106 == 4) goto L33;
        setVisibility(4);     // Catch: Throwable -> L45
        goto L40
    L33:
        setRealTenantName(r100.f482141a);     // Catch: Throwable -> L45
        goto L40
    L35:
        if (r100.f482143c == false) goto L37;
        setRealTenantName(r100.f482141a);     // Catch: Throwable -> L45
        goto L40
    L37:
        setVisibility(0);     // Catch: Throwable -> L45
        getIvTenantNameFromXml().setText(UIUtils.getString(getContext(), R.string.Lark_IM_Profile_AddAsExternalContactToViewOrgInfo_Placeholder));     // Catch: Throwable -> L45
        goto L40
    L25:
        r106 = b.f461122a[r105.ordinal()];     // Catch: Throwable -> L45
        goto L26
    L18:
        if (r103.length() == 0) goto L21;
        r104 = false;
    L45:
        th = move-exception;
        qqb.a.a();
        throw th;
    }

    public TenantNameTextView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 0);
    }

    public TenantNameTextView(Context r110, AttributeSet r111, int r112) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r110, r111, r112);
        FrameLayout.inflate(getContext(), R.layout.view_tenant_name, this);
        Resources.Theme r100 = r110.getTheme();     // Catch: Throwable -> L27
        int r101 = android.R.attr.gravity;
        int r102 = 2;
        int r113 = 3;
        int r114 = 7;
        TypedArray r103 = r100.obtainStyledAttributes(r111, new int[]{android.R.attr.gravity, R.attr.drawablePadding, R.attr.drawableStart, R.attr.ellipsize, R.attr.maxLines, R.attr.singleLine, R.attr.textColor, R.attr.textSize}, r112, 0);     // Catch: Throwable -> L27
        int r104 = r103.getIndexCount();     // Catch: Throwable -> L27
        int r105 = 0;
    L4:
        if (r105 >= r104) goto L83;
        int r115 = r103.getIndex(r105);     // Catch: Throwable -> L27
        if (r115 != r114) goto L13;
        float r116 = UIUtils.px2sp(r110, r103.getDimensionPixelSize(r115, 0));     // Catch: Throwable -> L27
        TextView r117 = getIvTenantNameFromXml();     // Catch: Throwable -> L27
        if (r117 == null) goto L10;
        r117.setTextSize(r116);     // Catch: Throwable -> L27
    L10:
        TextView r118 = getIvTenantCertTagFromXml();     // Catch: Throwable -> L27
        if (r118 == null) goto L58;
        r118.setTextSize(r116);     // Catch: Throwable -> L27
    L58:
        r105 = r105 + 1;
        r101 = android.R.attr.gravity;
        r102 = 2;
        r113 = 3;
        r114 = 7;
        goto L4
    L13:
        if (r115 != 6) goto L17;
        TextView r119 = getIvTenantNameFromXml();     // Catch: Throwable -> L27
        if (r119 == null) goto L58;
        r119.setTextColor(r103.getColor(r115, 0));     // Catch: Throwable -> L27
        goto L58
    L17:
        if (r115 != 4) goto L21;
        int r120 = r103.getInt(r115, 1);     // Catch: Throwable -> L27
        TextView r121 = getIvTenantNameFromXml();     // Catch: Throwable -> L27
        if (r121 == null) goto L58;
        r121.setMaxLines(r120);     // Catch: Throwable -> L27
        goto L58
    L21:
        if (r115 != r113) goto L23;
        setEllipsize(r103.getInt(r115, -1));     // Catch: Throwable -> L27
        goto L58
    L23:
        if (r115 != 1) goto L29;
        TextView r122 = getIvTenantNameFromXml();     // Catch: Throwable -> L27
        if (r122 == null) goto L58;
        r122.setCompoundDrawablePadding(r103.getDimensionPixelSize(r115, 0));     // Catch: Throwable -> L27
        goto L58
    L29:
        FrameLayout.LayoutParams r123 = null;
        if (r115 != 0) goto L43;
        LinearLayout r124 = getTenantNameContainerFromXml();     // Catch: Throwable -> L27
        if (r124 == null) goto L34;
        ViewGroup.LayoutParams r125 = r124.getLayoutParams();     // Catch: Throwable -> L27
    L36:
        if ((r125 instanceof FrameLayout.LayoutParams) == false) goto L38;
        r123 = (FrameLayout.LayoutParams) r125;     // Catch: Throwable -> L27
    L38:
        if (r123 == null) goto L58;
        TypedArray r126 = r110.obtainStyledAttributes(r111, new int[]{r101});     // Catch: Throwable -> L27
        r123.gravity = r126.getInteger(0, GravityCompat.END);     // Catch: Throwable -> L27
        LinearLayout r127 = getTenantNameContainerFromXml();     // Catch: Throwable -> L27
        if (r127 == null) goto L42;
        r127.setLayoutParams(r123);     // Catch: Throwable -> L27
    L42:
        r126.recycle();     // Catch: Throwable -> L27
        goto L58
    L34:
        r125 = null;
        goto L36
    L43:
        if (r115 != r102) goto L54;
        TextView r128 = getIvTenantNameFromXml();     // Catch: Throwable -> L27
        if (r128 == null) goto L58;
        if (r128.getLayoutDirection() != 1) goto L51;
        TextView r106 = (TextView) r128.findViewById(R.id.iv_tenant_name);     // Catch: Throwable -> L27
        if (r106 == null) goto L58;
        r106.setCompoundDrawablesWithIntrinsicBounds(null, null, r103.getDrawable(r115), null);     // Catch: Throwable -> L27
        goto L58
    L51:
        TextView r107 = (TextView) r128.findViewById(R.id.iv_tenant_name);     // Catch: Throwable -> L27
        if (r107 == null) goto L58;
        r107.setCompoundDrawablesWithIntrinsicBounds(r103.getDrawable(r115), null, null, null);     // Catch: Throwable -> L27
        goto L58
    L54:
        if (r115 != 5) goto L58;
        TextView r108 = getIvTenantNameFromXml();     // Catch: Throwable -> L27
        if (r108 == null) goto L58;
        r108.setSingleLine(r103.getBoolean(r115, false));     // Catch: Throwable -> L27
        goto L58
    L83:
        return;
    L27:
        th = move-exception;
        Log.e("TenantName", "TenantNameTextView init failed", th);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r100, int r101, int r102, int r103, int r104) {
        super.onLayout(r100, r101, r102, r103, r104);
    L13:
        th = move-exception;
        Log.e("TenantName", "adjust 2 lines layout failed", th);
        return;
    L4:
        if (getIvTenantNameFromXml().getLayout().getLineCount() > 1) goto L6;
        return;
    L6:
        if (getTenantNameContainerFromXml().getOrientation() == 1) goto L19;
        TextView r105 = getIvTenantNameFromXml();     // Catch: Throwable -> L13
        gpc.a r106 = this.f461120d;     // Catch: Throwable -> L13
        if (r106 == null) goto L10;
        String r107 = r106.f482141a;     // Catch: Throwable -> L13
    L11:
        r105.setText(r107);     // Catch: Throwable -> L13
        getIvTenantNameFromXml().invalidate();     // Catch: Throwable -> L13
        getIvTenantNameFromXml().requestLayout();     // Catch: Throwable -> L13
        getTenantNameContainerFromXml().setOrientation(1);     // Catch: Throwable -> L13
        return;
    L10:
        r107 = null;
        goto L11
    }
}
