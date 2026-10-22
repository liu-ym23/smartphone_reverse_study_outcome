package com.suite.lark.platform.component.widget_biz_fileview;

import acc.d;
import android.content.Context;
import android.content.res.ColorStateList;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Space;
import android.widget.TextView;
import androidx.constraintlayout.widget.Barrier;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.core.view.GravityCompat;
import com.larksuite.component.ui.display.manager.zoom.LarkFont;
import com.larksuite.component.ui.imageview.LKUIRoundedImageView;
import com.larksuite.component.universe_design.color.UDColorUtils;
import com.larksuite.framework.utils.FileUtils;
import com.larksuite.framework.utils.UIUtils;
import com.larus.nova.R;
import com.ss.android.lark.image.entity.ResourceCleanScene;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.utils.a0;
import com.ss.android.lark.widget.cleanresource.ResourceType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes36.dex */
public class FileView extends ConstraintLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Guideline f460880a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Guideline f460881b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public FileNameView f460882c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public TextView f460883d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public TextView f460884e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public TextView f460885f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public TextView f460886g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public LKUIRoundedImageView f460887h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public LKUIRoundedImageView f460888i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public ProgressBar f460889j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public View f460890k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public LinearLayout f460891l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public View f460892m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public View f460893n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public Guideline f460894o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public View f460895p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public b f460896q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public c f460897r;

    public static class FileState {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f460898a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f460899b;

        @Retention(RetentionPolicy.SOURCE)
        public @interface FileStateType {
            public static final int COMPRESSING = 4;
            public static final int DONE = 6;
            public static final int DOWNLOAD = 1;
            public static final int DOWNLOADING = 2;
            public static final int PAUSE = 5;
            public static final int UPLOADING = 3;
        }

        public FileState(int r100, String r101) {
            this.f460898a = r100;
            this.f460899b = r101;
        }
    }

    public static final enum ReceiveAuthorizationState extends Enum<ReceiveAuthorizationState> {
        public static final ReceiveAuthorizationState FINAL_AUTHORIZATION_STATE_DENY = null;
        public static final ReceiveAuthorizationState FINAL_AUTHORIZATION_STATE_PASS = null;
        public static final ReceiveAuthorizationState MIDDLE_AUTHORIZATION_STATE = null;
        public static final ReceiveAuthorizationState NORMAL_STATE = null;
        public static final ReceiveAuthorizationState UNKNOWN = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ ReceiveAuthorizationState[] f460900a = null;

        static {
            ReceiveAuthorizationState r100 = new ReceiveAuthorizationState("UNKNOWN", 0);
            UNKNOWN = r100;
            ReceiveAuthorizationState r101 = new ReceiveAuthorizationState("MIDDLE_AUTHORIZATION_STATE", 1);
            MIDDLE_AUTHORIZATION_STATE = r101;
            ReceiveAuthorizationState r102 = new ReceiveAuthorizationState("FINAL_AUTHORIZATION_STATE_PASS", 2);
            FINAL_AUTHORIZATION_STATE_PASS = r102;
            ReceiveAuthorizationState r103 = new ReceiveAuthorizationState("FINAL_AUTHORIZATION_STATE_DENY", 3);
            FINAL_AUTHORIZATION_STATE_DENY = r103;
            ReceiveAuthorizationState r104 = new ReceiveAuthorizationState("NORMAL_STATE", 4);
            NORMAL_STATE = r104;
            f460900a = new ReceiveAuthorizationState[]{r100, r101, r102, r103, r104};
        }

        public static ReceiveAuthorizationState[] values() {
            return (ReceiveAuthorizationState[]) f460900a.clone();
        }

        public static ReceiveAuthorizationState valueOf(int r100) {
            if (r100 == 0) goto L22;
            if (r100 == 1) goto L20;
            if (r100 == 2) goto L18;
            if (r100 == 3) goto L16;
            if (r100 == 4) goto L14;
            return UNKNOWN;
        L14:
            return NORMAL_STATE;
        L16:
            return FINAL_AUTHORIZATION_STATE_DENY;
        L18:
            return FINAL_AUTHORIZATION_STATE_PASS;
        L20:
            return MIDDLE_AUTHORIZATION_STATE;
        L22:
            return UNKNOWN;
        }

        public static ReceiveAuthorizationState valueOf(String r100) {
            return (ReceiveAuthorizationState) r27.a.a(ReceiveAuthorizationState.class, r100);
        }

        public ReceiveAuthorizationState(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f460901a = null;

        static {
            int[] r100 = new int[ReceiveAuthorizationState.values().length];
            f460901a = r100;
            r100[ReceiveAuthorizationState.MIDDLE_AUTHORIZATION_STATE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L8:
            f460901a[ReceiveAuthorizationState.FINAL_AUTHORIZATION_STATE_DENY.ordinal()] = 2;     // Catch: NoSuchFieldError -> L7
            return;
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f460902a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f460903b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f460904c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final boolean f460905d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final boolean f460906e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final boolean f460907f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final String f460908g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final FileState f460909h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final String f460910i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final long f460911j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final int f460912k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final long f460913l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final boolean f460914m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public final boolean f460915n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public final boolean f460916o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public final boolean f460917p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public final String f460918q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public final int f460919r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public final ResourceCleanScene f460920s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public final String f460921t;

        public b(boolean r100, boolean r101, boolean r102, boolean r103, boolean r104, boolean r105, boolean r110, boolean r111, boolean r112, String r113, FileState r114, String r115, long r116, int r117, long r118, boolean r210, String r211, int r212, ResourceCleanScene r213, String r214) {
            this.f460902a = r100;
            this.f460914m = r101;
            this.f460915n = r102;
            this.f460903b = r103;
            this.f460904c = r104;
            this.f460905d = r105;
            this.f460906e = r110;
            this.f460907f = r111;
            this.f460908g = r113;
            this.f460909h = r114;
            this.f460910i = r115;
            this.f460911j = r116;
            this.f460912k = r117;
            this.f460917p = r112;
            this.f460913l = r118;
            this.f460916o = r210;
            this.f460918q = r211;
            this.f460919r = r212;
            this.f460920s = r213;
            this.f460921t = r214;
        }
    }

    public static class c {
        public c() {
        }

        public void a() {
        }

        public void b(b r100) {
        }

        public void c(b r100) {
            throw null;
        }

        public void d(b r100) {
            throw null;
        }
    }

    public final void S5() {
        zz7.a.a(this.f460888i, 16);
        TextView r100 = this.f460883d;
        LarkFont r101 = LarkFont.CAPTION0;
        zz7.a.d(r100, r101);
        zz7.a.d(this.f460886g, r101);
        zz7.a.d(this.f460885f, r101);
        zz7.a.d(this.f460884e, r101);
        zz7.a.d(this.f460882c, LarkFont.HEADLINE);
        zz7.a.a(this.f460890k, 20);
        zz7.a.b(this.f460887h, 36, 36);
    }

    public final void T5() {
        ResourceType r100 = ResourceType.FILE;
        b r101 = this.f460896q;
        d r102 = new d(r100, r101.f460920s, acc.a.d(r101.f460921t));
        acc.a.f(getContext(), r102);
    }

    public final void R5() {
        Context r100 = getContext();
        int r101 = UIUtils.dp2px(r100, 12.0f);
        ((ConstraintLayout.LayoutParams) this.f460894o.getLayoutParams()).guideBegin = UIUtils.dp2px(r100, 11.0f);
        ((ConstraintLayout.LayoutParams) this.f460880a.getLayoutParams()).guideBegin = r101;
        ((ConstraintLayout.LayoutParams) this.f460881b.getLayoutParams()).guideEnd = r101;
    }

    public LKUIRoundedImageView getFileIconView() {
        return this.f460887h;
    }

    public FileView(Context r100) {
        this(r100, null);
    }

    public void setBottomMargin(boolean r100) {
        if (r100 == false) goto L4;
        this.f460893n.setVisibility(0);
        return;
    L4:
        this.f460893n.setVisibility(8);
    }

    public void setCallback(c r100) {
        this.f460897r = r100;
    }

    public void setFileSizeVisibility(boolean r100) {
        if (r100 == false) goto L4;
        this.f460886g.setGravity(GravityCompat.END);
        this.f460883d.setVisibility(0);
        return;
    L4:
        this.f460886g.setGravity(GravityCompat.START);
        this.f460883d.setVisibility(8);
    }

    public void setInfo(b r110) {
        this.f460896q = r110;
        if (r110 == null) goto L97;
        ReceiveAuthorizationState r100 = ReceiveAuthorizationState.valueOf(r110.f460919r);
        int[] r101 = a.f460901a;
        int r102 = r101[r100.ordinal()];
        boolean r103 = false;
        if (r102 == 1) goto L8;
        if (r102 == 2) goto L8;
        boolean r104 = false;
    L9:
        b r105 = this.f460896q;
        if (r105.f460914m == true) goto L12;
    L19:
        UIUtils.hide(this.f460884e);
        UIUtils.hide(this.f460888i);
        UIUtils.show(this.f460883d);
        if (this.f460896q.f460902a == false) goto L22;
        UIUtils.show(this.f460885f);
    L23:
        b r111 = this.f460896q;
        if (r111.f460909h.f460898a != 3) goto L26;
        boolean r106 = true;
    L27:
        if (r106 == false) goto L29;
        this.f460889j.setProgress(r111.f460912k);
        UIUtils.show(this.f460889j);
    L30:
        b r112 = this.f460896q;
        if (r112.f460906e == false) goto L34;
        this.f460886g.setVisibility(0);
        this.f460886g.setTextColor(UIUtils.getColor(getContext(), R.color.text_placeholder));
        this.f460886g.setText(UIUtils.getString(getContext(), R.string.Lark_IM_ViewOrDownloadFile_FileDeleted_Text));
    L44:
        if (this.f460896q.f460917p == false) goto L48;
        if (r104 == true) goto L48;
        this.f460882c.setTextColor(UIUtils.getColor(getContext(), R.color.text_title));
    L49:
        b r113 = this.f460896q;
        StringBuilder r107 = new StringBuilder(FileUtils.h(r113.f460911j));
        int r108 = r101[ReceiveAuthorizationState.valueOf(r113.f460919r).ordinal()];
        if (r108 == 1) goto L53;
        if (r108 == 2) goto L53;
        boolean r109 = false;
    L54:
        if (r109 == false) goto L59;
        r107 = new StringBuilder(UIHelper.getString(R.string.Lark_IM_UnableToView_Empty));
        if (ReceiveAuthorizationState.valueOf(this.f460896q.f460919r) != ReceiveAuthorizationState.FINAL_AUTHORIZATION_STATE_DENY) goto L59;
        r107 = new StringBuilder(UIHelper.getString(R.string.Lark_IM_NoReceivingPermission_Text));
    L59:
        if (r113.f460917p == true) goto L62;
        if (r109 == true) goto L62;
        r107 = new StringBuilder(UIHelper.getString(R.string.Lark_IM_UnableToPreview_Button));
    L68:
        boolean r114 = false;
    L69:
        if (r114 == false) goto L72;
        r107.append(" ");
        r107.append(FileUtils.h(r113.f460913l));
        r107.append("/s");
    L72:
        if (TextUtils.isEmpty(r113.f460918q) == true) goto L74;
        r107.append(" ");
        r107.append(r113.f460918q);
    L74:
        SpannableStringBuilder r115 = new SpannableStringBuilder(r107);
        if (r109 == false) goto L77;
    L78:
        r103 = true;
    L80:
        if (r113.f460920s == null) goto L83;
        if (r103 == true) goto L83;
        String r116 = UIUtils.getString(getContext(), R.string.Lark_IM_FileExpiredByAdmin_Label);
        int r117 = UIUtils.getColor(getContext(), R.color.function_danger_400);
        r115.append(tb2.c.DEFAULT_TEXT).append(r116);
        r115.setSpan(new ForegroundColorSpan(r117), r115.length() - r116.length(), r115.length(), 18);
    L83:
        this.f460883d.setText(r115);
    L84:
        this.f460882c.setText(this.f460896q.f460910i);
        b r118 = this.f460896q;
        if (r118.f460916o == false) goto L87;
        this.f460882c.setEllipsize(TextUtils.TruncateAt.END);
    L88:
        b r119 = this.f460896q;
        if (r119.f460916o == false) goto L91;
        this.f460887h.setImageResource(a0.c(r119.f460908g, r119.f460910i, true));
        return;
    L91:
        String r120 = r119.f460910i;
        if (TextUtils.isEmpty(r120) == false) goto L94;
        String r121 = this.f460896q.f460908g;
    L95:
        this.f460887h.setImageResource(a0.b(r121, r120, 1));
        return;
    L94:
        r121 = null;
        goto L95
    L87:
        String r122 = FileUtils.m(r118.f460910i);
        this.f460882c.setTailContent(r122);
        goto L88
    L77:
        if (r113.f460917p == true) goto L80;
    L62:
        int r123 = r113.f460909h.f460898a;
        if (r123 != 3) goto L65;
        r107.append(" ");
        r107.append(UIUtils.getString(getContext(), R.string.Lark_Legacy_Uploading));
    L67:
        r114 = true;
        goto L69
    L65:
        if (r123 != 2) goto L68;
        r107.append(" ");
        r107.append(UIUtils.getString(getContext(), R.string.Lark_Legacy_FileDownloading));
    L53:
        r109 = true;
    L48:
        this.f460882c.setTextColor(UIUtils.getColor(getContext(), R.color.text_placeholder));
        goto L49
    L34:
        if (r112.f460903b == false) goto L37;
        this.f460886g.setVisibility(0);
        this.f460886g.setTextColor(UIUtils.getColor(getContext(), R.color.text_placeholder));
        this.f460886g.setText(UIUtils.getString(getContext(), R.string.Lark_Legacy_FileStatusSourceDelete));
        goto L44
    L37:
        if (r112.f460904c == false) goto L39;
    L42:
        this.f460886g.setVisibility(0);
        this.f460886g.setTextColor(UIUtils.getColor(getContext(), R.color.text_placeholder));
        this.f460886g.setText(UIUtils.getString(getContext(), R.string.Lark_ChatFileStorage_ChatFileDeletedByAdmin));
        goto L44
    L39:
        if (r112.f460905d == true) goto L42;
        this.f460886g.setVisibility(8);
        this.f460886g.setTextColor(UIUtils.getColor(getContext(), R.color.primary_fill_default));
        this.f460886g.setText(this.f460896q.f460909h.f460899b);
        goto L44
    L29:
        UIUtils.hide(this.f460889j);
        goto L30
    L26:
        r106 = false;
        goto L27
    L22:
        UIUtils.hide(this.f460885f);
        goto L23
    L12:
        if (r105.f460917p == false) goto L19;
        if (r104 == true) goto L19;
        UIUtils.show(this.f460884e);
        UIUtils.show(this.f460888i);
        UIUtils.hide(this.f460883d);
        UIUtils.hide(this.f460885f);
        UIUtils.hide(this.f460889j);
        TextView r124 = this.f460884e;
        if (r110.f460915n == false) goto L17;
        int r125 = R.string.Lark_Message_file_lan_sendreceived;
    L18:
        r124.setText(r125);
        goto L84
    L17:
        r125 = R.string.Lark_Message_file_lan_mobilereceived;
    L8:
        r104 = true;
        goto L9
    }

    public void setTopBorderColor(int r100) {
        this.f460895p.setBackgroundColor(r100);
    }

    public void setTopBorderVisibility(boolean r100) {
        View r101 = this.f460895p;
        if (r100 == false) goto L5;
        int r102 = 0;
    L6:
        r101.setVisibility(r102);
        return;
    L5:
        r102 = 8;
        goto L6
    }

    public FileView(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    public FileView(Context r110, AttributeSet r111, int r112) {
        super(r110, r111, r112);
        Guideline r100 = new Guideline(r110);
        this.f460880a = r100;
        r100.setId(R.id.left_guideline);
        ConstraintLayout.LayoutParams r101 = new ConstraintLayout.LayoutParams(-2, -2);
        r101.orientation = 1;
        addView(this.f460880a, r101);
        Guideline r102 = new Guideline(r110);
        this.f460881b = r102;
        r102.setId(R.id.right_guideline);
        ConstraintLayout.LayoutParams r103 = new ConstraintLayout.LayoutParams(-2, -2);
        r103.orientation = 1;
        addView(this.f460881b, r103);
        Guideline r104 = new Guideline(r110);
        this.f460894o = r104;
        r104.setId(R.id.top_guideline);
        ConstraintLayout.LayoutParams r105 = new ConstraintLayout.LayoutParams(-2, -2);
        r105.orientation = 0;
        r105.topToTop = 0;
        addView(this.f460894o, r105);
        ProgressBar r106 = new ProgressBar(r110, null, android.R.attr.progressBarStyleHorizontal);
        this.f460889j = r106;
        r106.setId(R.id.progressbar);
        this.f460889j.setProgressDrawable(UIUtils.getDrawable(r110, R.drawable.file_message_progress_bar));
        ConstraintLayout.LayoutParams r107 = xbc.b.a(0.0f, 3.0f);
        r107.bottomToBottom = 0;
        r107.startToStart = 0;
        r107.endToEnd = 0;
        addView(this.f460889j, r107);
        Barrier r108 = new Barrier(r110);
        r108.setId(R.id.file_info_barrier);
        r108.setType(3);
        r108.setDpMargin(4);
        r108.setReferencedIds(new int[]{R.id.tv_file_name});
        addView(r108);
        TextView r109 = new TextView(r110);
        this.f460883d = r109;
        r109.setId(R.id.tv_file_size);
        this.f460883d.setTextColor(UIUtils.getColor(r110, R.color.text_placeholder));
        this.f460883d.setTextSize(12.0f);
        this.f460883d.setMaxLines(2);
        ConstraintLayout.LayoutParams r113 = new ConstraintLayout.LayoutParams(-2, -2);
        r113.topToBottom = R.id.file_info_barrier;
        r113.startToStart = R.id.tv_file_name;
        r113.endToStart = R.id.tv_file_size_space;
        r113.constrainedWidth = true;
        addView(this.f460883d, r113);
        View r114 = new Space(r110);
        r114.setId(R.id.tv_file_size_space);
        ConstraintLayout.LayoutParams r115 = new ConstraintLayout.LayoutParams(0, 1);
        r115.startToEnd = R.id.tv_file_size;
        r115.endToStart = R.id.tv_file_state;
        r115.constrainedWidth = true;
        r115.matchConstraintMinWidth = 1;
        addView(r114, r115);
        TextView r116 = new TextView(r110);
        this.f460886g = r116;
        r116.setId(R.id.tv_file_state);
        this.f460886g.setEllipsize(TextUtils.TruncateAt.MIDDLE);
        this.f460886g.setSingleLine(true);
        this.f460886g.setTextColor(UIUtils.getColor(r110, R.color.primary_fill_default));
        this.f460886g.setTextSize(12.0f);
        this.f460886g.setGravity(GravityCompat.END);
        ConstraintLayout.LayoutParams r117 = new ConstraintLayout.LayoutParams(-2, -2);
        ((ViewGroup.MarginLayoutParams) r117).leftMargin = y9c.d.b(r110, 2.0f);
        r117.topToBottom = R.id.file_info_barrier;
        r117.endToStart = R.id.tv_from_drive;
        r117.startToEnd = R.id.tv_file_size_space;
        r117.constrainedWidth = true;
        r117.goneStartMargin = 0;
        addView(this.f460886g, r117);
        TextView r118 = new TextView(r110);
        this.f460885f = r118;
        r118.setId(R.id.tv_from_drive);
        this.f460885f.setText(R.string.Lark_Legacy_FileFromDrive);
        this.f460885f.setGravity(GravityCompat.END);
        this.f460885f.setTextColor(UIUtils.getColor(r110, R.color.text_placeholder));
        this.f460885f.setTextSize(12.0f);
        ConstraintLayout.LayoutParams r119 = new ConstraintLayout.LayoutParams(0, -2);
        r119.topToBottom = R.id.file_info_barrier;
        r119.endToStart = R.id.btn_file_progress_close;
        addView(this.f460885f, r119);
        View r120 = new View(r110);
        r120.setVisibility(4);
        ConstraintLayout.LayoutParams r121 = xbc.b.a(-1.0f, 1.0f);
        r121.topToBottom = 0;
        r121.startToStart = R.id.left_guideline;
        r121.endToEnd = R.id.right_guideline;
        addView(r120, r121);
        View r122 = new View(r110);
        this.f460890k = r122;
        r122.setId(R.id.btn_file_progress_close);
        this.f460890k.setBackgroundResource(R.drawable.ud_icon_close_outlined);
        this.f460890k.setBackgroundTintList(ColorStateList.valueOf(UDColorUtils.getColor(r110, R.color.icon_n1)));
        this.f460890k.setVisibility(8);
        ConstraintLayout.LayoutParams r123 = xbc.b.a(20.0f, 20.0f);
        r123.topToBottom = R.id.file_info_barrier;
        r123.endToEnd = R.id.right_guideline;
        addView(this.f460890k, r123);
        LKUIRoundedImageView r124 = new LKUIRoundedImageView(r110);
        this.f460887h = r124;
        r124.setId(R.id.image_file_icon);
        this.f460887h.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.f460887h.setOval(false);
        ConstraintLayout.LayoutParams r125 = xbc.b.a(36.0f, 36.0f);
        r125.startToStart = R.id.left_guideline;
        r125.topToTop = this.f460894o.getId();
        addView(this.f460887h, r125);
        FileNameView r126 = new FileNameView(r110);
        this.f460882c = r126;
        r126.setId(R.id.tv_file_name);
        this.f460882c.setMaxLines(3);
        this.f460882c.setLineSpacing(2.5f, 1.0f);
        this.f460882c.setTextColor(UIUtils.getColor(r110, R.color.text_title));
        this.f460882c.setTextSize(17.0f);
        this.f460882c.setIncludeFontPadding(false);
        ConstraintLayout.LayoutParams r127 = new ConstraintLayout.LayoutParams(0, -2);
        ((ViewGroup.MarginLayoutParams) r127).leftMargin = y9c.d.b(r110, 8.0f);
        r127.topToTop = this.f460894o.getId();
        r127.startToEnd = R.id.image_file_icon;
        r127.endToEnd = R.id.right_guideline;
        addView(this.f460882c, r127);
        TextView r128 = new TextView(r110);
        this.f460884e = r128;
        r128.setId(R.id.lan_trans_notice);
        this.f460884e.setMaxLines(3);
        this.f460884e.setTextColor(UIUtils.getColor(r110, R.color.text_placeholder));
        this.f460884e.setTextSize(12.0f);
        ConstraintLayout.LayoutParams r129 = new ConstraintLayout.LayoutParams(0, -2);
        r129.topToBottom = R.id.file_info_barrier;
        r129.startToStart = R.id.tv_file_name;
        r129.endToEnd = R.id.right_guideline;
        addView(this.f460884e, r129);
        LKUIRoundedImageView r130 = new LKUIRoundedImageView(r110);
        this.f460888i = r130;
        r130.setId(R.id.lan_trans_indicator);
        this.f460888i.setScaleType(ImageView.ScaleType.FIT_CENTER);
        this.f460888i.setOval(false);
        this.f460888i.setImageResource(R.drawable.ic_icon_file_lan_trans);
        ConstraintLayout.LayoutParams r131 = xbc.b.a(16.0f, 16.0f);
        r131.endToEnd = R.id.image_file_icon;
        r131.bottomToBottom = R.id.image_file_icon;
        addView(this.f460888i, r131);
        Barrier r132 = new Barrier(r110);
        r132.setId(R.id.preview_barrier);
        r132.setReferencedIds(new int[]{R.id.image_file_icon, R.id.tv_file_name, R.id.tv_file_size, R.id.tv_file_state, R.id.tv_from_drive, R.id.lan_trans_notice});
        r132.setAllowsGoneWidget(false);
        r132.setType(3);
        addView(r132);
        LinearLayout r133 = new LinearLayout(r110);
        this.f460891l = r133;
        r133.setId(R.id.preview_container);
        ConstraintLayout.LayoutParams r134 = new ConstraintLayout.LayoutParams(0, -2);
        r134.startToStart = R.id.left_guideline;
        r134.endToEnd = R.id.right_guideline;
        r134.topToBottom = R.id.preview_barrier;
        ((ViewGroup.MarginLayoutParams) r134).topMargin = y9c.d.b(r110, 12.0f);
        addView(this.f460891l, r134);
        View r135 = new View(r110);
        this.f460892m = r135;
        r135.setId(R.id.preview_mask);
        ConstraintLayout.LayoutParams r136 = new ConstraintLayout.LayoutParams(0, 0);
        r136.startToStart = R.id.preview_container;
        r136.endToEnd = R.id.preview_container;
        r136.topToTop = R.id.preview_container;
        r136.bottomToBottom = R.id.preview_container;
        addView(this.f460892m, r136);
        Space r137 = new Space(r110);
        this.f460893n = r137;
        r137.setId(R.id.bottom_space);
        ConstraintLayout.LayoutParams r138 = new ConstraintLayout.LayoutParams(0, y9c.d.b(r110, 12.0f));
        r138.topToBottom = R.id.preview_container;
        r138.startToStart = R.id.left_guideline;
        r138.endToEnd = R.id.right_guideline;
        addView(this.f460893n, r138);
        this.f460895p = new View(r110);
        ConstraintLayout.LayoutParams r139 = new ConstraintLayout.LayoutParams(0, y9c.d.b(r110, 1.0f));
        r139.topToTop = 0;
        r139.startToStart = 0;
        r139.endToEnd = 0;
        addView(this.f460895p, r139);
        R5();
        setOnClickListener(new bpc.a(this));
        this.f460892m.setOnClickListener(new bpc.b(this));
        this.f460892m.setOnLongClickListener(new bpc.c(this));
        this.f460890k.setOnClickListener(new com.suite.lark.platform.component.widget_biz_fileview.a(this));
    }
}
