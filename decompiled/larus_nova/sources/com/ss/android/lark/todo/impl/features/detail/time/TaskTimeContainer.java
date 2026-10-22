package com.ss.android.lark.todo.impl.features.detail.time;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import com.larksuite.component.universe_design.color.UDColorUtils;
import com.larksuite.component.universe_design.icon.UDIconUtils;
import com.larus.nova.R;
import com.ss.android.lark.todo.dependency.TodoDependencyHolder;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\"\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001eB'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010N\u001a\u00020OH\u0002J\b\u0010P\u001a\u00020OH\u0002J\b\u0010Q\u001a\u00020OH\u0002J&\u0010R\u001a\u00020O2\u0006\u0010<\u001a\u00020=2\u0006\u0010S\u001a\u00020T2\u0006\u0010U\u001a\u00020T2\u0006\u0010V\u001a\u00020=J\u0016\u0010W\u001a\u00020O2\u0006\u0010S\u001a\u00020T2\u0006\u0010V\u001a\u00020=J\u0016\u0010X\u001a\u00020O2\u0006\u0010U\u001a\u00020T2\u0006\u0010V\u001a\u00020=J\u0018\u0010Y\u001a\u00020O2\u0006\u0010S\u001a\u00020T2\u0006\u0010V\u001a\u00020=H\u0002J\u0018\u0010Z\u001a\u00020O2\u0006\u0010U\u001a\u00020T2\u0006\u0010V\u001a\u00020=H\u0002J\u000e\u0010[\u001a\u00020O2\u0006\u0010\\\u001a\u00020LJ(\u0010]\u001a\u00020O2\u0006\u0010^\u001a\u00020\u00072\u0006\u0010_\u001a\u00020\u00072\u0006\u0010`\u001a\u00020\u00072\u0006\u0010a\u001a\u00020\u0007H\u0014J\u0010\u0010b\u001a\u00020O2\u0006\u0010c\u001a\u00020dH\u0014R\u001e\u0010\n\u001a\u0004\u0018\u00010\u000b8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0010\u001a\u0004\u0018\u00010\u000b8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR\u001e\u0010\u0013\u001a\u0004\u0018\u00010\u000b8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\r\"\u0004\b\u0015\u0010\u000fR\u001e\u0010\u0016\u001a\u0004\u0018\u00010\u000b8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\r\"\u0004\b\u0018\u0010\u000fR\u001e\u0010\u0019\u001a\u0004\u0018\u00010\u001a8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001e\u0010\u001f\u001a\u0004\u0018\u00010\u001a8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u001c\"\u0004\b!\u0010\u001eR\u001e\u0010\"\u001a\u0004\u0018\u00010\u001a8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u001c\"\u0004\b$\u0010\u001eR\u001e\u0010%\u001a\u0004\u0018\u00010\u001a8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u001c\"\u0004\b'\u0010\u001eR\u001e\u0010(\u001a\u0004\u0018\u00010\u001a8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u001c\"\u0004\b*\u0010\u001eR\u001e\u0010+\u001a\u0004\u0018\u00010\u001a8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\u001c\"\u0004\b-\u0010\u001eR\u001e\u0010.\u001a\u0004\u0018\u00010\u00018FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\u001e\u00103\u001a\u0004\u0018\u00010\u00018FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u00100\"\u0004\b5\u00102R\u001e\u00106\u001a\u0004\u0018\u00010\u00018FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u00100\"\u0004\b8\u00102R\u001e\u00109\u001a\u0004\u0018\u00010\u00018FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u00100\"\u0004\b;\u00102R\u000e\u0010<\u001a\u00020=X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010>\u001a\u00020=X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010?\u001a\u00020@X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010A\u001a\u00020@X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010B\u001a\u00020CX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010D\u001a\u00020EX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010F\u001a\u00020EX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010G\u001a\u00020EX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010H\u001a\u00020EX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010I\u001a\u00020EX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010J\u001a\u00020EX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010K\u001a\u0004\u0018\u00010LX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010M\u001a\u00020=X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006f"}, d2 = {"Lcom/ss/android/lark/todo/impl/features/detail/time/TaskTimeContainer;", "Landroid/widget/LinearLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "startNoTimeIconFromXml", "Landroidx/appcompat/widget/AppCompatImageView;", "getStartNoTimeIconFromXml", "()Landroidx/appcompat/widget/AppCompatImageView;", "setStartNoTimeIconFromXml", "(Landroidx/appcompat/widget/AppCompatImageView;)V", "startHaveTimeCloseIconFromXml", "getStartHaveTimeCloseIconFromXml", "setStartHaveTimeCloseIconFromXml", "endNoTimeIconFromXml", "getEndNoTimeIconFromXml", "setEndNoTimeIconFromXml", "endHaveTimeCloseIconFromXml", "getEndHaveTimeCloseIconFromXml", "setEndHaveTimeCloseIconFromXml", "startNoTimeTxtFromXml", "Landroid/widget/TextView;", "getStartNoTimeTxtFromXml", "()Landroid/widget/TextView;", "setStartNoTimeTxtFromXml", "(Landroid/widget/TextView;)V", "startTimeDateTxtFromXml", "getStartTimeDateTxtFromXml", "setStartTimeDateTxtFromXml", "startTimeSpecificTxtFromXml", "getStartTimeSpecificTxtFromXml", "setStartTimeSpecificTxtFromXml", "endNoTimeTxtFromXml", "getEndNoTimeTxtFromXml", "setEndNoTimeTxtFromXml", "endTimeDateTxtFromXml", "getEndTimeDateTxtFromXml", "setEndTimeDateTxtFromXml", "endTimeSpecificTxtFromXml", "getEndTimeSpecificTxtFromXml", "setEndTimeSpecificTxtFromXml", "startHaveTimeContainerFromXml", "getStartHaveTimeContainerFromXml", "()Landroid/widget/LinearLayout;", "setStartHaveTimeContainerFromXml", "(Landroid/widget/LinearLayout;)V", "startNoTimeContainerFromXml", "getStartNoTimeContainerFromXml", "setStartNoTimeContainerFromXml", "endHaveTimeContainerFromXml", "getEndHaveTimeContainerFromXml", "setEndHaveTimeContainerFromXml", "endNoTimeContainerFromXml", "getEndNoTimeContainerFromXml", "setEndNoTimeContainerFromXml", "isSelectStart", "", "isSelectEnd", "selectStartPath", "Landroid/graphics/Path;", "selectEndPath", "selectPaint", "Landroid/graphics/Paint;", "divideViewWidth", "", "divideTopLocation", "divideCenterLocation", "divideBottomLocation", "width", "height", "mTimeChosenListener", "Lcom/ss/android/lark/todo/impl/features/detail/time/TaskTimeContainer$ITaskTimeChosenListener;", "isTwelveHour", "initView", "", "startTimeViewClick", "endTimeViewClick", "setInitDate", "startTimeMillis", "", "endTimeMillis", "isAllDay", "setStartDate", "setEndDate", "initStartTime", "initEndTime", "setOnTimeChosenListener", "listener", "onSizeChanged", "w", "h", "oldw", "oldh", "onDraw", "canvas", "Landroid/graphics/Canvas;", "ITaskTimeChosenListener", "todo_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TaskTimeContainer extends LinearLayout {
    public final boolean A;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public AppCompatImageView f443493a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public AppCompatImageView f443494b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public AppCompatImageView f443495c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public AppCompatImageView f443496d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public TextView f443497e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public TextView f443498f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public TextView f443499g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public TextView f443500h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public TextView f443501i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public TextView f443502j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public LinearLayout f443503k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public LinearLayout f443504l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public LinearLayout f443505m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public LinearLayout f443506n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f443507o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f443508p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public Path f443509q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public Path f443510r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final Paint f443511s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final float f443512t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public float f443513u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public float f443514v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public float f443515w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public float f443516x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public float f443517y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public a f443518z;

    public interface a {
        void a();

        void b();

        void c();

        void d();
    }

    public TaskTimeContainer(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public TaskTimeContainer(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public final AppCompatImageView getEndHaveTimeCloseIconFromXml() {
        KeyEvent.Callback r100 = this.f443496d;
        if (r100 != null) goto L6;
        r100 = findViewById(R.id.end_have_time_close_icon);
        this.f443496d = (AppCompatImageView) r100;
    L6:
        return (AppCompatImageView) r100;
    }

    public final LinearLayout getEndHaveTimeContainerFromXml() {
        KeyEvent.Callback r100 = this.f443505m;
        if (r100 != null) goto L6;
        r100 = findViewById(R.id.end_have_time_container);
        this.f443505m = (LinearLayout) r100;
    L6:
        return (LinearLayout) r100;
    }

    public final LinearLayout getEndNoTimeContainerFromXml() {
        KeyEvent.Callback r100 = this.f443506n;
        if (r100 != null) goto L6;
        r100 = findViewById(R.id.end_no_time_container);
        this.f443506n = (LinearLayout) r100;
    L6:
        return (LinearLayout) r100;
    }

    public final AppCompatImageView getEndNoTimeIconFromXml() {
        KeyEvent.Callback r100 = this.f443495c;
        if (r100 != null) goto L6;
        r100 = findViewById(R.id.end_no_time_icon);
        this.f443495c = (AppCompatImageView) r100;
    L6:
        return (AppCompatImageView) r100;
    }

    public final TextView getEndNoTimeTxtFromXml() {
        KeyEvent.Callback r100 = this.f443500h;
        if (r100 != null) goto L6;
        r100 = findViewById(R.id.end_no_time_txt);
        this.f443500h = (TextView) r100;
    L6:
        return (TextView) r100;
    }

    public final TextView getEndTimeDateTxtFromXml() {
        KeyEvent.Callback r100 = this.f443501i;
        if (r100 != null) goto L6;
        r100 = findViewById(R.id.end_time_date_txt);
        this.f443501i = (TextView) r100;
    L6:
        return (TextView) r100;
    }

    public final TextView getEndTimeSpecificTxtFromXml() {
        KeyEvent.Callback r100 = this.f443502j;
        if (r100 != null) goto L6;
        r100 = findViewById(R.id.end_time_specific_txt);
        this.f443502j = (TextView) r100;
    L6:
        return (TextView) r100;
    }

    public final AppCompatImageView getStartHaveTimeCloseIconFromXml() {
        KeyEvent.Callback r100 = this.f443494b;
        if (r100 != null) goto L6;
        r100 = findViewById(R.id.start_have_time_close_icon);
        this.f443494b = (AppCompatImageView) r100;
    L6:
        return (AppCompatImageView) r100;
    }

    public final LinearLayout getStartHaveTimeContainerFromXml() {
        KeyEvent.Callback r100 = this.f443503k;
        if (r100 != null) goto L6;
        r100 = findViewById(R.id.start_have_time_container);
        this.f443503k = (LinearLayout) r100;
    L6:
        return (LinearLayout) r100;
    }

    public final LinearLayout getStartNoTimeContainerFromXml() {
        KeyEvent.Callback r100 = this.f443504l;
        if (r100 != null) goto L6;
        r100 = findViewById(R.id.start_no_time_container);
        this.f443504l = (LinearLayout) r100;
    L6:
        return (LinearLayout) r100;
    }

    public final AppCompatImageView getStartNoTimeIconFromXml() {
        KeyEvent.Callback r100 = this.f443493a;
        if (r100 != null) goto L6;
        r100 = findViewById(R.id.start_no_time_icon);
        this.f443493a = (AppCompatImageView) r100;
    L6:
        return (AppCompatImageView) r100;
    }

    public final TextView getStartNoTimeTxtFromXml() {
        KeyEvent.Callback r100 = this.f443497e;
        if (r100 != null) goto L6;
        r100 = findViewById(R.id.start_no_time_txt);
        this.f443497e = (TextView) r100;
    L6:
        return (TextView) r100;
    }

    public final TextView getStartTimeDateTxtFromXml() {
        KeyEvent.Callback r100 = this.f443498f;
        if (r100 != null) goto L6;
        r100 = findViewById(R.id.start_time_date_txt);
        this.f443498f = (TextView) r100;
    L6:
        return (TextView) r100;
    }

    public final TextView getStartTimeSpecificTxtFromXml() {
        KeyEvent.Callback r100 = this.f443499g;
        if (r100 != null) goto L6;
        r100 = findViewById(R.id.start_time_specific_txt);
        this.f443499g = (TextView) r100;
    L6:
        return (TextView) r100;
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onDraw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        super.onDraw(r100);
        r100.save();
        if (this.f443507o == false) goto L6;
        r100.drawPath(this.f443509q, this.f443511s);
    L6:
        if (this.f443508p == false) goto L8;
        r100.drawPath(this.f443510r, this.f443511s);
    L8:
        r100.restore();
    }

    public final void setEndHaveTimeCloseIconFromXml(AppCompatImageView r100) {
        this.f443496d = r100;
    }

    public final void setEndHaveTimeContainerFromXml(LinearLayout r100) {
        this.f443505m = r100;
    }

    public final void setEndNoTimeContainerFromXml(LinearLayout r100) {
        this.f443506n = r100;
    }

    public final void setEndNoTimeIconFromXml(AppCompatImageView r100) {
        this.f443495c = r100;
    }

    public final void setEndNoTimeTxtFromXml(TextView r100) {
        this.f443500h = r100;
    }

    public final void setEndTimeDateTxtFromXml(TextView r100) {
        this.f443501i = r100;
    }

    public final void setEndTimeSpecificTxtFromXml(TextView r100) {
        this.f443502j = r100;
    }

    public final void setOnTimeChosenListener(a r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.f443518z = r100;
    }

    public final void setStartHaveTimeCloseIconFromXml(AppCompatImageView r100) {
        this.f443494b = r100;
    }

    public final void setStartHaveTimeContainerFromXml(LinearLayout r100) {
        this.f443503k = r100;
    }

    public final void setStartNoTimeContainerFromXml(LinearLayout r100) {
        this.f443504l = r100;
    }

    public final void setStartNoTimeIconFromXml(AppCompatImageView r100) {
        this.f443493a = r100;
    }

    public final void setStartNoTimeTxtFromXml(TextView r100) {
        this.f443497e = r100;
    }

    public final void setStartTimeDateTxtFromXml(TextView r100) {
        this.f443498f = r100;
    }

    public final void setStartTimeSpecificTxtFromXml(TextView r100) {
        this.f443499g = r100;
    }

    public TaskTimeContainer(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        LayoutInflater.from(getContext()).inflate(R.layout.task_time_choose_container, this);
        AppCompatImageView r103 = getStartNoTimeIconFromXml();
        Context r104 = getContext();
        com.ss.android.lark.todo.impl.utils.i r105 = com.ss.android.lark.todo.impl.utils.i.f444291a;
        r103.setImageDrawable(UDIconUtils.getIconDrawable(r104, R.drawable.ud_icon_add_middle_outlined, r105.a(R.color.icon_n3)));
        getStartHaveTimeCloseIconFromXml().setImageDrawable(UDIconUtils.getIconDrawable(getContext(), R.drawable.ud_icon_close_outlined, r105.a(R.color.icon_n3)));
        getEndNoTimeIconFromXml().setImageDrawable(UDIconUtils.getIconDrawable(getContext(), R.drawable.ud_icon_add_middle_outlined, r105.a(R.color.static_white)));
        getEndHaveTimeCloseIconFromXml().setImageDrawable(UDIconUtils.getIconDrawable(getContext(), R.drawable.ud_icon_close_outlined, r105.a(R.color.static_white)));
        setOnTouchListener(new c(this));
        getStartHaveTimeCloseIconFromXml().setOnClickListener(new d(this));
        getEndHaveTimeCloseIconFromXml().setOnClickListener(new e(this));
        this.f443508p = true;
        this.f443509q = new Path();
        this.f443510r = new Path();
        Paint r106 = new Paint();
        r106.setColor(UDColorUtils.getColor(r100, R.color.primary_pri_500));
        r106.setStyle(Paint.Style.FILL);
        r106.setAntiAlias(true);
        this.f443511s = r106;
        this.f443512t = h18.d.c(r100, R.dimen.dp_12);
        this.A = !TodoDependencyHolder.a().timeFormatDependency().c();
    }

    public /* synthetic */ TaskTimeContainer(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    @Override // android.view.View
    public final void onSizeChanged(int r100, int r101, int r102, int r103) {
        float r104 = r100;
        this.f443516x = r104;
        this.f443517y = r101;
        float r105 = this.f443512t;
        float r106 = 2;
        float r107 = (r104 / 2.0f) - (r105 / r106);
        this.f443513u = r107;
        this.f443514v = r105 + r107;
        this.f443515w = r107;
        Path r108 = new Path();
        this.f443509q = r108;
        r108.moveTo(0.0f, 0.0f);
        this.f443509q.lineTo(this.f443513u, 0.0f);
        this.f443509q.lineTo(this.f443514v, this.f443517y / r106);
        this.f443509q.lineTo(this.f443515w, this.f443517y);
        this.f443509q.lineTo(0.0f, this.f443517y);
        this.f443509q.close();
        Path r109 = new Path();
        this.f443510r = r109;
        r109.moveTo(this.f443513u, 0.0f);
        this.f443510r.lineTo(this.f443514v, this.f443517y / r106);
        this.f443510r.lineTo(this.f443515w, this.f443517y);
        this.f443510r.lineTo(this.f443516x, this.f443517y);
        this.f443510r.lineTo(this.f443516x, 0.0f);
        this.f443510r.close();
    }
}
