package com.obric.miniapp.lynx;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.byted.cast.linkcommon.cybergarage.upnp.RootDescription;
import com.bytedance.android.ecom.arch.slice.render.SlcElement;
import com.bytedance.map.api.monitor.MapMonitorConst;
import com.larus.nova.R;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.LynxProp;
import com.lynx.tasm.behavior.ui.LynxUI;
import com.obric.oui.calendar.MaterialCalendarView;
import com.obric.oui.calendar.ODatePickerView;
import com.ss.android.lark.chat.core.dependency.BrowserDependency;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.ttm.player.MediaPlayer;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000\u009e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b)\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0007\u0018\u0000 \u007f2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0003\u007f\u0080\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010)\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020*H\u0014J\u0010\u0010+\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020*H\u0002J\b\u0010,\u001a\u00020-H\u0002J\u0010\u0010.\u001a\u00020-2\u0006\u0010/\u001a\u00020\tH\u0002J\u0010\u00100\u001a\u00020-2\u0006\u00101\u001a\u000202H\u0016J\b\u00103\u001a\u00020-H\u0002J\n\u00104\u001a\u0004\u0018\u00010\tH\u0002J\u0012\u00105\u001a\u00020-2\b\u00106\u001a\u0004\u0018\u000107H\u0007J\u0012\u00108\u001a\u00020-2\b\u00109\u001a\u0004\u0018\u000107H\u0007J\u0012\u0010:\u001a\u00020-2\b\u00109\u001a\u0004\u0018\u000107H\u0007J\u0012\u0010;\u001a\u00020-2\b\u00109\u001a\u0004\u0018\u000107H\u0007J\u0017\u0010<\u001a\u00020-2\b\u0010=\u001a\u0004\u0018\u00010\u0016H\u0007¢\u0006\u0002\u0010>J\u0017\u0010?\u001a\u00020-2\b\u0010@\u001a\u0004\u0018\u00010\u0016H\u0007¢\u0006\u0002\u0010>J\u0017\u0010A\u001a\u00020-2\b\u0010B\u001a\u0004\u0018\u00010\u0016H\u0007¢\u0006\u0002\u0010>J\u0012\u0010C\u001a\u00020-2\b\u0010D\u001a\u0004\u0018\u000107H\u0007J\u0012\u0010E\u001a\u00020-2\b\u0010D\u001a\u0004\u0018\u000107H\u0007J\u0017\u0010F\u001a\u00020-2\b\u0010G\u001a\u0004\u0018\u00010\u0016H\u0007¢\u0006\u0002\u0010>J\u0017\u0010H\u001a\u00020-2\b\u0010G\u001a\u0004\u0018\u00010\u0016H\u0007¢\u0006\u0002\u0010>J\u0017\u0010I\u001a\u00020-2\b\u0010G\u001a\u0004\u0018\u00010\u0016H\u0007¢\u0006\u0002\u0010>J\u0017\u0010J\u001a\u00020-2\b\u0010K\u001a\u0004\u0018\u00010\u0016H\u0007¢\u0006\u0002\u0010>J\u0017\u0010L\u001a\u00020-2\b\u0010G\u001a\u0004\u0018\u00010\u0016H\u0007¢\u0006\u0002\u0010>J\u0017\u0010M\u001a\u00020-2\b\u0010N\u001a\u0004\u0018\u00010\u0016H\u0007¢\u0006\u0002\u0010>J\u0017\u0010O\u001a\u00020-2\b\u0010N\u001a\u0004\u0018\u00010\u0016H\u0007¢\u0006\u0002\u0010>J\u0017\u0010P\u001a\u00020-2\b\u0010Q\u001a\u0004\u0018\u00010\u000bH\u0007¢\u0006\u0002\u0010RJ\b\u0010S\u001a\u00020-H\u0016J\n\u0010T\u001a\u0004\u0018\u00010\u0002H\u0002J\n\u0010U\u001a\u0004\u0018\u00010\tH\u0002J\b\u0010V\u001a\u00020-H\u0002J\b\u0010W\u001a\u00020-H\u0002J\b\u0010X\u001a\u00020-H\u0002J\b\u0010Y\u001a\u00020\u000bH\u0002J\b\u0010Z\u001a\u00020\u001aH\u0002J\b\u0010[\u001a\u00020-H\u0002J\u001a\u0010\\\u001a\u00020-2\u0006\u0010/\u001a\u00020\t2\b\b\u0002\u0010]\u001a\u00020\u000bH\u0002J\u001a\u0010^\u001a\u00020-2\u0006\u0010/\u001a\u00020\t2\b\b\u0002\u0010]\u001a\u00020\u000bH\u0002J\u0010\u0010_\u001a\u00020-2\u0006\u0010`\u001a\u00020aH\u0002J\u0010\u0010b\u001a\u00020-2\u0006\u0010/\u001a\u00020\tH\u0002J\u0010\u0010c\u001a\u00020-2\u0006\u0010d\u001a\u00020%H\u0002J\b\u0010e\u001a\u00020-H\u0002J\u0010\u0010f\u001a\u00020-2\u0006\u0010d\u001a\u00020%H\u0002J\u0010\u0010g\u001a\u0002072\u0006\u0010h\u001a\u000207H\u0002J\u0012\u0010i\u001a\u00020-2\b\u0010/\u001a\u0004\u0018\u00010jH\u0002J\u0010\u0010k\u001a\u00020-2\u0006\u0010/\u001a\u00020\tH\u0002J\u0010\u0010l\u001a\u00020-2\u0006\u0010m\u001a\u00020nH\u0002J$\u0010o\u001a\u00020-2\u0006\u0010p\u001a\u00020j2\u0012\u0010q\u001a\u000e\u0012\u0004\u0012\u00020j\u0012\u0004\u0012\u00020-0rH\u0002J\u0018\u0010s\u001a\u00020-2\u0006\u0010t\u001a\u00020j2\u0006\u0010p\u001a\u00020\tH\u0002J\u0018\u0010u\u001a\u00020v2\u0006\u0010\u0003\u001a\u00020*2\u0006\u0010w\u001a\u00020\u0016H\u0002J\u0018\u0010x\u001a\u00020-2\u0006\u0010m\u001a\u00020n2\u0006\u0010y\u001a\u00020\u0016H\u0002J\u0019\u0010z\u001a\u0004\u0018\u00010\u000f2\b\u00109\u001a\u0004\u0018\u000107H\u0002¢\u0006\u0002\u0010{J\u0010\u0010|\u001a\u00020\u000f2\u0006\u0010D\u001a\u00020\u000fH\u0002J\u0018\u0010}\u001a\u00020-2\u0006\u0010~\u001a\u0002072\u0006\u00109\u001a\u00020\u0013H\u0002R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0002X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0010R\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0010R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0010R\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0017R\u0012\u0010\u0018\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0017R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u001b\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0017R\u0012\u0010\u001c\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0017R\u0012\u0010\u001d\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0017R\u0012\u0010\u001e\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0017R\u0012\u0010\u001f\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0017R\u0012\u0010 \u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0017R\u0012\u0010!\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\"R\u0010\u0010#\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010$\u001a\u0004\u0018\u00010%X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010&\u001a\u0004\u0018\u00010'X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0081\u0001"}, d2 = {"Lcom/obric/miniapp/lynx/LynxOUIDatePickerViewUI;", "Lcom/lynx/tasm/behavior/ui/LynxUI;", "Landroid/widget/FrameLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Lcom/lynx/tasm/behavior/LynxContext;", "<init>", "(Lcom/lynx/tasm/behavior/LynxContext;)V", "rootView", "datePickerView", "Lcom/obric/oui/calendar/ODatePickerView;", "suppressEvent", "", "optionsJson", "Lorg/json/JSONObject;", "minDateMillis", "", "Ljava/lang/Long;", "maxDateMillis", "selectedDate", "Ljava/time/LocalDate;", "selectedDateMillis", "headerPaddingLeft", "", "Ljava/lang/Integer;", "headerPaddingRight", "presentation", "Lcom/obric/miniapp/lynx/LynxOUIDatePickerViewUI$DatePickerPresentation;", "explicitHeightDp", "explicitContentHeightDp", "tileWidthDp", "tileHeightDp", "tileHSpacingDp", "tileVSpacingDp", "clipToBounds", "Ljava/lang/Boolean;", "boundDatePickerView", "headerTitleView", "Landroid/widget/TextView;", "headerTitleWatcher", "Landroid/text/TextWatcher;", "normalizingHeaderTitle", "createView", "Landroid/content/Context;", "createDatePickerView", "rebuildDatePickerView", "", "bindDatePickerView", "view", "updatePropertiesInterval", SlcElement.KEY_PROPS, "Lcom/lynx/tasm/behavior/StylesDiffMap;", "ensureDatePickerViewReady", "createDatePickerViewIfNeeded", "setOptions", "options", "", "setDate", "date", "setMinDate", "setMaxDate", "setHeaderPaddingLeft", "paddingLeft", "(Ljava/lang/Integer;)V", "setHeaderPaddingRight", "paddingRight", "setHeaderPaddingHorizontal", "paddingHorizontal", "setPresentation", "value", "setMode", "setHeight", "height", "setMinHeight", "setContentHeight", "setTileWidth", "width", "setTileHeight", "setTileHSpacing", "spacing", "setTileVSpacing", "setClipToBounds", "clip", "(Ljava/lang/Boolean;)V", MapMonitorConst.EVENT_DESTROY, "currentRootView", "currentDatePickerView", "applySelectedDateToView", "applyDatePickerHeight", "applyDatePickerClipping", "shouldUseCompactDatePickerBounds", "currentPresentation", "applyDatePickerContainerPadding", "applyDatePickerHeaderLayout", "patchCalendarMetrics", "patchDatePickerHeaderLayout", "patchDatePickerHeaderControls", "monthHeaderContainer", "Landroid/view/ViewGroup;", "compactDatePickerHeaderTitle", "bindDatePickerHeaderTitleNormalizer", "titleView", "unbindDatePickerHeaderTitleNormalizer", "normalizeDatePickerHeaderTitle", "compactDatePickerHeaderTitleText", "rawText", "clearHorizontalMargins", "Landroid/view/View;", "patchDatePickerCalendarMetrics", "relaxDatePickerCalendarClipping", "calendarView", "Lcom/obric/oui/calendar/MaterialCalendarView;", "forEachDescendant", RootDescription.ROOT_ELEMENT, "visitor", "Lkotlin/Function1;", "relaxClippingToDatePickerRoot", "start", "resolveDatePickerCalendarMetrics", "Lcom/obric/miniapp/lynx/DatePickerCalendarMetrics;", "availableWidth", "applyDatePickerPagerWidth", "pagerWidth", "parseDateMillis", "(Ljava/lang/String;)Ljava/lang/Long;", "clampDateMillis", "sendEvent", "type", "Companion", "DatePickerPresentation", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LynxOUIDatePickerViewUI extends LynxUI<FrameLayout> {

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final /* synthetic */ int f397901w = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public FrameLayout f397902a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ODatePickerView f397903b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f397904c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public JSONObject f397905d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Long f397906e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Long f397907f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public LocalDate f397908g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Long f397909h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Integer f397910i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Integer f397911j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public DatePickerPresentation f397912k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Integer f397913l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public Integer f397914m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public Integer f397915n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public Integer f397916o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public Integer f397917p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public Integer f397918q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public Boolean f397919r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public ODatePickerView f397920s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public TextView f397921t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public k2 f397922u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f397923v;

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0014\b\u0082\u0081\u0002\u0018\u0000 \u001c2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u001cB;\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t\u0012\b\b\u0002\u0010\u000b\u001a\u00020\t¢\u0006\u0004\b\f\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\n\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0015R\u0011\u0010\u000b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0015j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001b¨\u0006\u001d"}, d2 = {"Lcom/obric/miniapp/lynx/LynxOUIDatePickerViewUI$DatePickerPresentation;", "", "mode", "Lcom/obric/oui/calendar/ODatePickerView$DatePickerMode;", "defaultHeightDp", "", "clipToBounds", "", "tileHSpacingDp", "", "tileVSpacingDp", "defaultHeaderPaddingHorizontalDp", "<init>", "(Ljava/lang/String;ILcom/obric/oui/calendar/ODatePickerView$DatePickerMode;IZFFF)V", "getMode", "()Lcom/obric/oui/calendar/ODatePickerView$DatePickerMode;", "getDefaultHeightDp", "()I", "getClipToBounds", "()Z", "getTileHSpacingDp", "()F", "getTileVSpacingDp", "getDefaultHeaderPaddingHorizontalDp", "BOARD_SHEET", "NARROW_SHEET", "SELECT_DATE_SHEET", "EVENT_INLINE", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum DatePickerPresentation extends Enum<DatePickerPresentation> {
        public static final DatePickerPresentation BOARD_SHEET = null;
        public static final a Companion = null;
        public static final DatePickerPresentation EVENT_INLINE = null;
        public static final DatePickerPresentation NARROW_SHEET = null;
        public static final DatePickerPresentation SELECT_DATE_SHEET = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ DatePickerPresentation[] f397924a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f397925b = null;
        private final boolean clipToBounds;
        private final float defaultHeaderPaddingHorizontalDp;
        private final int defaultHeightDp;
        private final ODatePickerView.DatePickerMode mode;
        private final float tileHSpacingDp;
        private final float tileVSpacingDp;

        public static final class a {
            public a() {
            }
        }

        public static EnumEntries<DatePickerPresentation> getEntries() {
            return f397925b;
        }

        static {
            ODatePickerView.DatePickerMode r210 = ODatePickerView.DatePickerMode.BOARD_SHEET;
            DatePickerPresentation r110 = new DatePickerPresentation("BOARD_SHEET", 0, r210, MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_MAX_RETRANSMISSION_TIME_MS, false, 6.0f, 4.0f, 0.0f, 32, null);
            BOARD_SHEET = r110;
            DatePickerPresentation r100 = new DatePickerPresentation("NARROW_SHEET", 1, r210, MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_MAX_RETRANSMISSION_TIME_MS, false, 6.0f, 4.0f, 0.0f, 32, null);
            NARROW_SHEET = r100;
            DatePickerPresentation r101 = new DatePickerPresentation("SELECT_DATE_SHEET", 2, r210, MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_MAX_RETRANSMISSION_TIME_MS, false, 6.0f, 4.0f, 3.0f);
            SELECT_DATE_SHEET = r101;
            DatePickerPresentation r102 = new DatePickerPresentation("EVENT_INLINE", 3, r210, MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_MAX_RETRANSMISSION_TIME_MS, true, 6.0f, 4.0f, 0.0f, 32, null);
            EVENT_INLINE = r102;
            DatePickerPresentation[] r103 = {r110, r100, r101, r102};
            f397924a = r103;
            f397925b = EnumEntriesKt.enumEntries(r103);
            Companion = new a();
        }

        public static DatePickerPresentation[] values() {
            return (DatePickerPresentation[]) f397924a.clone();
        }

        public final boolean getClipToBounds() {
            return this.clipToBounds;
        }

        public final float getDefaultHeaderPaddingHorizontalDp() {
            return this.defaultHeaderPaddingHorizontalDp;
        }

        public final int getDefaultHeightDp() {
            return this.defaultHeightDp;
        }

        public final ODatePickerView.DatePickerMode getMode() {
            return this.mode;
        }

        public final float getTileHSpacingDp() {
            return this.tileHSpacingDp;
        }

        public final float getTileVSpacingDp() {
            return this.tileVSpacingDp;
        }

        public static DatePickerPresentation valueOf(String r100) {
            return (DatePickerPresentation) r27.a.a(DatePickerPresentation.class, r100);
        }

        public DatePickerPresentation(String r100, int r101, ODatePickerView.DatePickerMode r102, int r103, boolean r104, float r105, float r106, float r107) {
            super(r100, r101);
            this.mode = r102;
            this.defaultHeightDp = r103;
            this.clipToBounds = r104;
            this.tileHSpacingDp = r105;
            this.tileVSpacingDp = r106;
            this.defaultHeaderPaddingHorizontalDp = r107;
        }

        public /* synthetic */ DatePickerPresentation(String r110, int r111, ODatePickerView.DatePickerMode r112, int r113, boolean r114, float r115, float r116, float r117, int r118, DefaultConstructorMarker r210) {
            if ((r118 & 32) == 0) goto L5;
            float r100 = 0.0f;
        L6:
            this(r110, r111, r112, r113, r114, r115, r116, r100);
            return;
        L5:
            r100 = r117;
            goto L6
        }
    }

    public static final class a {
    }

    static {
    }

    public final void M() {
        Boolean r100 = this.f397919r;
        if (r100 == null) goto L5;
        boolean r101 = r100.booleanValue();
    L6:
        FrameLayout r102 = T();
        if (r102 == null) goto L9;
        r102.setClipChildren(r101);
        r102.setClipToPadding(r101);
    L9:
        ODatePickerView r103 = S();
        if (r103 == null) goto L12;
        r103.setClipChildren(r101);
        r103.setClipToPadding(r101);
    L12:
        FrameLayout r104 = T();
        if (r104 == null) goto L42;
        Boolean r105 = this.f397919r;
        if (r105 == null) goto L18;
        boolean r106 = r105.booleanValue();
    L19:
        if (r106 == true) goto L21;
        int r107 = o1.s(r104.getContext(), 16.0f);
        int r108 = o1.s(r104.getContext(), 6.0f);
        int r109 = o1.s(r104.getContext(), 16.0f);
        if (r104.getPaddingLeft() == r107) goto L32;
    L37:
        r104.setPadding(r107, r108, r107, r109);
        return;
    L32:
        if (r104.getPaddingTop() != r108) goto L37;
        if (r104.getPaddingRight() != r107) goto L37;
        if (r104.getPaddingBottom() != r109) goto L37;
        return;
    L21:
        if (r104.getPaddingLeft() == 0) goto L23;
    L28:
        r104.setPadding(0, 0, 0, 0);
        return;
    L23:
        if (r104.getPaddingTop() != 0) goto L28;
        if (r104.getPaddingRight() != 0) goto L28;
        if (r104.getPaddingBottom() != 0) goto L28;
        return;
    L18:
        r106 = this.f397912k.getClipToBounds();
        goto L19
    L42:
        return;
    L5:
        r101 = this.f397912k.getClipToBounds();
        goto L6
    }

    public final ODatePickerView S() {
        ODatePickerView r100 = this.f397903b;
        if (r100 != null) goto L16;
        FrameLayout r101 = T();
        if (r101 == null) goto L7;
        View r102 = r101.getChildAt(0);
    L9:
        if ((r102 instanceof ODatePickerView) == false) goto L11;
        ODatePickerView r103 = (ODatePickerView) r102;
    L12:
        if (r103 == null) goto L15;
        this.f397903b = r103;
        return r103;
    L15:
        return null;
    L11:
        r103 = null;
        goto L12
    L7:
        r102 = null;
        goto L9
    L16:
        return r100;
    }

    public final FrameLayout T() {
        FrameLayout r100 = this.f397902a;
        if (r100 != null) goto L9;
        FrameLayout r101 = getView();
        if (r101 == null) goto L7;
        this.f397902a = r101;
        return r101;
    L7:
        return null;
    L9:
        return r100;
    }

    public final void Y() {
        TextView r100 = this.f397921t;
        k2 r101 = this.f397922u;
        if (r100 == null) goto L6;
        if (r101 == null) goto L6;
        r100.removeTextChangedListener(r101);
    L6:
        this.f397921t = null;
        this.f397922u = null;
        this.f397923v = false;
    }

    public final void O() {
        FrameLayout r100 = T();
        if (r100 != null) goto L5;
        return;
    L5:
        Context r101 = r100.getContext();
        Integer r102 = this.f397913l;
        if (r102 == null) goto L8;
        int r103 = r102.intValue();
    L9:
        int r104 = o1.s(r101, r103);
        FrameLayout.LayoutParams r105 = null;
        if ((r100 instanceof e) == false) goto L12;
        e r106 = (e) r100;
    L13:
        if (r106 == null) goto L19;
        if (r104 <= 0) goto L19;
        if (r106.f398069a == r104) goto L19;
        r106.f398069a = r104;
        r106.requestLayout();
    L19:
        ODatePickerView r107 = S();
        if (r107 != null) goto L22;
        return;
    L22:
        ViewGroup.LayoutParams r108 = r107.getLayoutParams();
        if ((r108 instanceof FrameLayout.LayoutParams) == false) goto L26;
        r105 = (FrameLayout.LayoutParams) r108;
    L26:
        if (r105 != null) goto L28;
        r105 = new FrameLayout.LayoutParams(-1, -1);
    L28:
        r105.width = -1;
        Integer r109 = this.f397914m;
        if (r109 == null) goto L31;
        int r110 = o1.s(r107.getContext(), r109.intValue());
    L32:
        r105.height = r110;
        r107.setLayoutParams(r105);
        r107.setMinimumHeight(0);
        M();
        return;
    L31:
        r110 = -2;
        goto L32
    L12:
        r106 = null;
        goto L13
    L8:
        r103 = this.f397912k.getDefaultHeightDp();
        goto L9
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI, com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void destroy() {
        Y();
        this.f397902a = null;
        this.f397903b = null;
        this.f397920s = null;
        this.f397908g = null;
        this.f397909h = null;
        super.destroy();
    }

    public LynxOUIDatePickerViewUI(LynxContext r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        this.f397912k = DatePickerPresentation.BOARD_SHEET;
        if (r100.getDefaultOverflowVisible() == false) goto L6;
        this.mOverflow = 3;
        return;
    }

    public static void Q(View r100) {
        ViewGroup.MarginLayoutParams r101 = null;
        if (r100 == null) goto L5;
        ViewGroup.LayoutParams r102 = r100.getLayoutParams();
    L7:
        if ((r102 instanceof ViewGroup.MarginLayoutParams) == false) goto L9;
        r101 = (ViewGroup.MarginLayoutParams) r102;
    L9:
        if (r101 != null) goto L12;
        return;
    L12:
        if (r101.leftMargin == 0) goto L14;
    L20:
        r101.leftMargin = 0;
        r101.rightMargin = 0;
        r101.setMarginStart(0);
        r101.setMarginEnd(0);
        r100.setLayoutParams(r101);
        return;
    L14:
        if (r101.rightMargin != 0) goto L20;
        if (r101.getMarginStart() != 0) goto L20;
        if (r101.getMarginEnd() != 0) goto L20;
        return;
    L5:
        r102 = null;
        goto L7
    }

    public final long P(long r100) {
        Long r101 = this.f397906e;
        Long r102 = this.f397907f;
        if (r101 != null) goto L5;
    L7:
        if (r102 != null) goto L9;
        return r100;
    L9:
        if (r100 > r102.longValue()) goto L11;
        return r100;
    L11:
        return r102.longValue();
    L5:
        if (r100 >= r101.longValue()) goto L7;
        return r101.longValue();
    }

    public final ODatePickerView R(Context r100) {
        ODatePickerView r101 = new ODatePickerView(r100, null, 0, this.f397912k.getMode(), 16);
        r101.setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
        r101.setClipChildren(false);
        r101.setClipToPadding(false);
        r101.setOutOfMonthVisibility(ODatePickerView.OutOfMonthVisibility.GREY);
        return r101;
    }

    public final Long V(String r100) {
        Object r101 = null;
        if (r100 == null) goto L5;
        String r102 = StringsKt.trim(r100).toString();
    L6:
        if (r102 != null) goto L9;
        r102 = "";
    L9:
        if (r102.length() != 0) goto L11;
        boolean r103 = true;
    L12:
        if (r103 == false) goto L14;
        return null;
    L14:
        Long r104 = StringsKt.toLongOrNull(r102);
        if (r104 != null) goto L17;
        Result.Companion r105 = Result.Companion;     // Catch: Throwable -> L20
        Object r106 = Result.m9449constructorimpl(Long.valueOf(LocalDate.parse(r102).atStartOfDay(ZoneId.systemDefault()).toInstant().toEpochMilli()));     // Catch: Throwable -> L20
    L23:
        if (Result.m9455isFailureimpl(r106) == true) goto L27;
        r101 = r106;
    L27:
        return (Long) r101;
    L20:
        th = move-exception;
        Result.Companion r107 = Result.Companion;
        r106 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L23
    L17:
        return Long.valueOf(r104.longValue());
    L11:
        r103 = false;
        goto L12
    L5:
        r102 = null;
        goto L6
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.obric.miniapp.lynx.d2] */
    public final void W(ODatePickerView r100) {
        final MaterialCalendarView r101 = (MaterialCalendarView) r100.findViewById(R.id.calendarView);
        if (r101 != null) goto L5;
        return;
    L5:
        U(r101, new j2());
        final ?? r102 = new d2(r101, this);
        r101.addOnLayoutChangeListener(new e2(r102));
        r101.post(new f2(r102));
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI
    public final View createView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        e r101 = new e(r100, o1.s(r100, 392.0f));
        r101.setId(R.id.content_container);
        r101.setClipChildren(false);
        r101.setClipToPadding(false);
        r101.setClipToOutline(false);
        r101.setBackground(new ColorDrawable(0));
        return r101;
    }

    @LynxProp(name = "clipToBounds")
    public final void setClipToBounds(Boolean r100) {
        this.f397919r = r100;
        M();
    }

    @LynxProp(name = "contentHeight")
    public final void setContentHeight(Integer r100) {
        if (r100 != null) goto L5;
    L10:
        r100 = null;
    L11:
        this.f397914m = r100;
        O();
        return;
    L5:
        if (r100.intValue() <= 0) goto L7;
        boolean r101 = true;
    L8:
        if (r101 == false) goto L10;
    L7:
        r101 = false;
        goto L8
    }

    @LynxProp(name = "date")
    public final void setDate(String r100) {
        Long r101 = V(r100);
        if (r101 == null) goto L9;
        long r102 = P(r101.longValue());
        this.f397908g = Instant.ofEpochMilli(r102).atZone(ZoneId.systemDefault()).toLocalDate();
        this.f397909h = Long.valueOf(r102);
        ODatePickerView r103 = S();
        if (r103 != null) goto L7;
        return;
    L7:
        this.f397904c = true;
        r103.setCurrentTimeMillis(r102);
        this.f397904c = false;
        N(r103, false);
        return;
    }

    @LynxProp(name = "headerPaddingHorizontal")
    public final void setHeaderPaddingHorizontal(Integer r100) {
        this.f397910i = r100;
        this.f397911j = r100;
        ODatePickerView r101 = S();
        if (r101 == null) goto L6;
        N(r101, false);
        return;
    }

    @LynxProp(name = "headerPaddingLeft")
    public final void setHeaderPaddingLeft(Integer r100) {
        this.f397910i = r100;
        ODatePickerView r101 = S();
        if (r101 == null) goto L6;
        N(r101, false);
        return;
    }

    @LynxProp(name = "headerPaddingRight")
    public final void setHeaderPaddingRight(Integer r100) {
        this.f397911j = r100;
        ODatePickerView r101 = S();
        if (r101 == null) goto L6;
        N(r101, false);
        return;
    }

    @LynxProp(name = "height")
    public final void setHeight(Integer r100) {
        if (r100 != null) goto L5;
    L10:
        r100 = null;
    L11:
        this.f397913l = r100;
        O();
        return;
    L5:
        if (r100.intValue() <= 0) goto L7;
        boolean r101 = true;
    L8:
        if (r101 == false) goto L10;
    L7:
        r101 = false;
        goto L8
    }

    @LynxProp(name = "maxDate")
    public final void setMaxDate(String r100) {
        this.f397907f = V(r100);
    }

    @LynxProp(name = "minDate")
    public final void setMinDate(String r100) {
        this.f397906e = V(r100);
    }

    @LynxProp(name = "minHeight")
    public final void setMinHeight(Integer r100) {
        setHeight(r100);
    }

    @LynxProp(name = "mode")
    public final void setMode(String r100) {
        setPresentation(r100);
    }

    @LynxProp(name = "options")
    public final void setOptions(String r100) {
        JSONObject r101 = o1.G(r100);
        this.f397905d = r101;
        if (r101 != null) goto L6;
        return;
    L6:
        if (r101.has("minDate") == false) goto L9;
        setMinDate(r101.optString("minDate"));
    L9:
        if (r101.has("maxDate") == false) goto L12;
        setMaxDate(r101.optString("maxDate"));
    L12:
        if (r101.has("headerPaddingLeft") == false) goto L15;
        setHeaderPaddingLeft(Integer.valueOf(r101.optInt("headerPaddingLeft")));
    L15:
        if (r101.has("headerPaddingRight") == false) goto L18;
        setHeaderPaddingRight(Integer.valueOf(r101.optInt("headerPaddingRight")));
    L18:
        if (r101.has("headerPaddingHorizontal") == false) goto L20;
        setHeaderPaddingHorizontal(Integer.valueOf(r101.optInt("headerPaddingHorizontal")));
    L20:
        String r102 = o1.C(r101, new String[]{"presentation", "mode"});
        if (r102 == null) goto L23;
        setPresentation(r102);
    L23:
        Integer r103 = o1.f(r101, new String[]{"height", "minHeight", "minHeightDp"});
        if (r103 == null) goto L26;
        setHeight(r103.intValue());
    L26:
        Integer r104 = o1.f(r101, new String[]{"contentHeight", "contentHeightDp"});
        if (r104 == null) goto L29;
        setContentHeight(Integer.valueOf(r104.intValue()));
    L29:
        Integer r105 = o1.f(r101, new String[]{"tileWidth", "tileWidthDp"});
        if (r105 == null) goto L32;
        setTileWidth(Integer.valueOf(r105.intValue()));
    L32:
        Integer r106 = o1.f(r101, new String[]{"tileHeight", "tileHeightDp"});
        if (r106 == null) goto L35;
        setTileHeight(Integer.valueOf(r106.intValue()));
    L35:
        Integer r107 = o1.f(r101, new String[]{"tileHSpacing", "tileHSpacingDp"});
        if (r107 == null) goto L38;
        setTileHSpacing(Integer.valueOf(r107.intValue()));
    L38:
        Integer r108 = o1.f(r101, new String[]{"tileVSpacing", "tileVSpacingDp"});
        if (r108 == null) goto L41;
        setTileVSpacing(Integer.valueOf(r108.intValue()));
    L41:
        Boolean r109 = o1.B(r101, new String[]{"clipToBounds", "clip"});
        if (r109 == null) goto L44;
        setClipToBounds(Boolean.valueOf(r109.booleanValue()));
    L44:
        setDate(o1.C(r101, new String[]{"date", "value"}));
    }

    @LynxProp(name = "presentation")
    public final void setPresentation(String r100) {
        DatePickerPresentation.Companion.getClass();
        if (r100 == null) goto L7;
        String r101 = StringsKt.trim(r100).toString();
        if (r101 == null) goto L7;
        String r102 = r101.toLowerCase(Locale.US);
    L8:
        if (r102 != null) goto L10;
    L42:
        DatePickerPresentation r103 = DatePickerPresentation.BOARD_SHEET;
    L44:
        if (this.f397912k != r103) goto L46;
        return;
    L46:
        this.f397912k = r103;
        FrameLayout r104 = T();
        if (r104 == null) goto L57;
        ODatePickerView r105 = R(r104.getContext());
        Y();
        r104.removeAllViews();
        r104.addView(r105);
        this.f397903b = r105;
        this.f397920s = null;
        r105.setOnDateChangedListener(new h2(this, r105));
        r105.setOnMonthChangedListener(new i2(this, r105));
        this.f397920s = r105;
        O();
        ODatePickerView r106 = S();
        if (r106 == null) goto L55;
        Long r107 = this.f397909h;
        if (r107 == null) goto L55;
        long r108 = r107.longValue();
        this.f397904c = true;
        r106.setCurrentTimeMillis(r108);
        this.f397904c = false;
    L55:
        N(r105, true);
        return;
    L57:
        return;
    L10:
        switch(r102.hashCode()) {
            case -1807624732: goto L39;
            case -1655486806: goto L35;
            case -1183997287: goto L31;
            case -1052669861: goto L28;
            case -764127109: goto L25;
            case 731265459: goto L22;
            case 768076766: goto L19;
            case 1516613877: goto L16;
            case 1846747313: goto L13;
            default: goto L42;
        };
    L13:
        if (r102.equals("select_date_sheet") == false) goto L42;
    L37:
        r103 = DatePickerPresentation.SELECT_DATE_SHEET;
        goto L44
    L16:
        if (r102.equals("selectdatesheet") == true) goto L37;
    L19:
        if (r102.equals("event_inline") == false) goto L42;
    L33:
        r103 = DatePickerPresentation.EVENT_INLINE;
        goto L44
    L22:
        if (r102.equals("eventinline") == true) goto L33;
    L25:
        if (r102.equals("narrow_sheet") == false) goto L42;
    L41:
        r103 = DatePickerPresentation.NARROW_SHEET;
        goto L44
    L28:
        if (r102.equals("narrow") == true) goto L41;
    L31:
        if (r102.equals(BrowserDependency.UrlClickType.INLINE) == true) goto L33;
    L35:
        if (r102.equals("selectdate") == true) goto L37;
    L39:
        if (r102.equals("narrowsheet") == true) goto L41;
    L7:
        r102 = null;
        goto L8
    }

    @LynxProp(name = "tileHSpacing")
    public final void setTileHSpacing(Integer r100) {
        if (r100 != null) goto L5;
    L10:
        r100 = null;
    L11:
        this.f397917p = r100;
        ODatePickerView r101 = S();
        if (r101 == null) goto L15;
        W(r101);
        return;
    L15:
        return;
    L5:
        if (r100.intValue() < 0) goto L7;
        boolean r102 = true;
    L8:
        if (r102 == false) goto L10;
    L7:
        r102 = false;
        goto L8
    }

    @LynxProp(name = "tileHeight")
    public final void setTileHeight(Integer r100) {
        if (r100 != null) goto L5;
    L10:
        r100 = null;
    L11:
        this.f397916o = r100;
        ODatePickerView r101 = S();
        if (r101 == null) goto L15;
        W(r101);
        return;
    L15:
        return;
    L5:
        if (r100.intValue() <= 0) goto L7;
        boolean r102 = true;
    L8:
        if (r102 == false) goto L10;
    L7:
        r102 = false;
        goto L8
    }

    @LynxProp(name = "tileVSpacing")
    public final void setTileVSpacing(Integer r100) {
        if (r100 != null) goto L5;
    L10:
        r100 = null;
    L11:
        this.f397918q = r100;
        ODatePickerView r101 = S();
        if (r101 == null) goto L15;
        W(r101);
        return;
    L15:
        return;
    L5:
        if (r100.intValue() < 0) goto L7;
        boolean r102 = true;
    L8:
        if (r102 == false) goto L10;
    L7:
        r102 = false;
        goto L8
    }

    @LynxProp(name = "tileWidth")
    public final void setTileWidth(Integer r100) {
        if (r100 != null) goto L5;
    L10:
        r100 = null;
    L11:
        this.f397915n = r100;
        ODatePickerView r101 = S();
        if (r101 == null) goto L15;
        W(r101);
        return;
    L15:
        return;
    L5:
        if (r100.intValue() <= 0) goto L7;
        boolean r102 = true;
    L8:
        if (r102 == false) goto L10;
    L7:
        r102 = false;
        goto L8
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void updatePropertiesInterval(com.lynx.tasm.behavior.x0 r210) {
        Intrinsics.checkNotNullParameter(r210, SlcElement.KEY_PROPS);
        ODatePickerView r100 = null;
        super.updatePropertiesInterval(o1.S(r210, this.f397905d, new String[]{"date", "value", "minDate", "maxDate", "headerPaddingLeft", "headerPaddingRight", "headerPaddingHorizontal", "presentation", "mode", "minHeight", "contentHeight", "tileWidth", "tileHeight", "tileHSpacing", "tileVSpacing", "clipToBounds"}, null, 10));
        ODatePickerView r101 = S();
        if (r101 != null) goto L17;
        FrameLayout r102 = T();
        if (r102 == null) goto L13;
        View r103 = r102.getChildAt(0);
        if ((r103 instanceof ODatePickerView) == false) goto L10;
        r100 = (ODatePickerView) r103;
    L10:
        if (r100 == null) goto L12;
        this.f397903b = r100;
        goto L13
    L12:
        r100 = R(r102.getContext());
        r102.addView(r100);
        this.f397903b = r100;
    L13:
        if (r100 == null) goto L27;
        r101 = r100;
        goto L17
    L27:
        return;
    L17:
        if (this.f397920s == r101) goto L28;
        r101.setOnDateChangedListener(new h2(this, r101));
        r101.setOnMonthChangedListener(new i2(this, r101));
        this.f397920s = r101;
        O();
        ODatePickerView r104 = S();
        if (r104 == null) goto L25;
        Long r105 = this.f397909h;
        if (r105 == null) goto L25;
        long r106 = r105.longValue();
        this.f397904c = true;
        r104.setCurrentTimeMillis(r106);
        this.f397904c = false;
    L25:
        N(r101, true);
        return;
    }

    public static void U(View r100, j2 r101) {
        r101.invoke(r100);
        if ((r100 instanceof ViewGroup) == false) goto L5;
        ViewGroup r102 = (ViewGroup) r100;
    L6:
        if (r102 != null) goto L8;
        return;
    L8:
        int r103 = r102.getChildCount();
        int r104 = 0;
    L9:
        if (r104 >= r103) goto L11;
        U(r102.getChildAt(r104), r101);
        r104 = r104 + 1;
        goto L9
    L11:
        return;
    L5:
        r102 = null;
        goto L6
    }

    public final void N(final ODatePickerView r100, boolean r101) {
        X(r100, r101);
        r100.post(new g2(this, r100));
    }

    public final void X(ODatePickerView r100, boolean r110) {
        View r101 = r100.findViewById(R.id.ll_open_year_month);
        if (r101 != null) goto L5;
        return;
    L5:
        ViewParent r102 = r101.getParent();
        ConstraintLayout.LayoutParams r103 = null;
        if ((r102 instanceof ViewGroup) == false) goto L8;
        ViewGroup r104 = (ViewGroup) r102;
    L9:
        if (r104 != null) goto L11;
        return;
    L11:
        float r105 = this.f397912k.getDefaultHeaderPaddingHorizontalDp();
        Context r106 = r100.getContext();
        Integer r107 = this.f397910i;
        if (r107 == null) goto L14;
        float r108 = r107.intValue();
    L15:
        int r109 = o1.s(r106, r108);
        Context r111 = r100.getContext();
        Integer r112 = this.f397911j;
        if (r112 == null) goto L18;
        int r113 = r112.intValue();
    L21:
        r105 = r113;
    L22:
        r104.setPadding(r109, r104.getPaddingTop(), o1.s(r111, r105), r104.getPaddingBottom());
        r101.setPadding(0, r101.getPaddingTop(), 0, r101.getPaddingBottom());
        Q(r101);
        View r114 = r104.findViewById(R.id.previousBtn);
        View r115 = r104.findViewById(R.id.nextBtn);
        Q(r114);
        Q(r115);
        if (r114 == null) goto L25;
        ViewGroup.LayoutParams r116 = r114.getLayoutParams();
    L27:
        if ((r116 instanceof ConstraintLayout.LayoutParams) == false) goto L29;
        ConstraintLayout.LayoutParams r117 = (ConstraintLayout.LayoutParams) r116;
    L31:
        if (r117 == null) goto L33;
        r117.startToStart = -1;
        r117.startToEnd = -1;
        r117.endToEnd = -1;
        r117.endToStart = R.id.nextBtn;
        r114.setLayoutParams(r117);
    L33:
        if (r115 == null) goto L35;
        ViewGroup.LayoutParams r118 = r115.getLayoutParams();
    L37:
        if ((r118 instanceof ConstraintLayout.LayoutParams) == false) goto L39;
        r103 = (ConstraintLayout.LayoutParams) r118;
    L39:
        if (r103 == null) goto L41;
        r103.startToStart = -1;
        r103.startToEnd = -1;
        r103.endToStart = -1;
        r103.endToEnd = 0;
        r115.setLayoutParams(r103);
    L41:
        r104.requestLayout();
        TextView r119 = (TextView) r100.findViewById(R.id.currentDateTextView);
        if (r119 != null) goto L45;
    L63:
        if (r110 == false) goto L68;
        W(r100);
        return;
    L68:
        return;
    L45:
        if (this.f397921t == r119) goto L47;
    L49:
        Y();
        k2 r120 = new k2(this);
        this.f397921t = r119;
        this.f397922u = r120;
        r119.addTextChangedListener(r120);
    L50:
        CharSequence r121 = r119.getText();
        if (r121 == null) goto L63;
        String r122 = r121.toString();
        if (r122 == null) goto L63;
        String r123 = new Regex("\\s*月\\s*").replace(new Regex("\\s*年\\s*").replace(r122, "年"), "月");
        if (Intrinsics.areEqual(r123, r122) == true) goto L63;
        this.f397923v = true;
        r119.setText(r123);     // Catch: Throwable -> L60
        this.f397923v = false;
    L60:
        th = move-exception;
        this.f397923v = false;
        throw th;
    L47:
        if (this.f397922u == null) goto L49;
    L35:
        r118 = null;
        goto L37
    L29:
        r117 = null;
        goto L31
    L25:
        r116 = null;
        goto L27
    L18:
        Integer r124 = this.f397910i;
        if (r124 == null) goto L22;
        r113 = r124.intValue();
        goto L21
    L14:
        r108 = r105;
        goto L15
    L8:
        r104 = null;
        goto L9
    }
}
