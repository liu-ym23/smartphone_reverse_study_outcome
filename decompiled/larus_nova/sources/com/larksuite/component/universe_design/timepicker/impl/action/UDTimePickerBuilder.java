package com.larksuite.component.universe_design.timepicker.impl.action;

import android.content.Context;
import com.byted.mgl.merge.service.api.ui.BdpGameHostBaseUIService;
import com.larksuite.component.universe_design.dialog.UDBaseDialogBuilder;
import com.larksuite.component.universe_design.dialog.UDDialog;
import com.larksuite.component.universe_design.timepicker.impl.data.PickerModel;
import com.larksuite.component.universe_design.util.CalendarDate;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Calendar;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class UDTimePickerBuilder extends UDBaseDialogBuilder<UDTimePickerBuilder> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public PickerModel f285362a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f285363b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Integer f285364c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public a f285365d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f285366e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public a f285367f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f285368g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f285369h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Calendar f285370i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public CalendarDate f285371j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public CalendarDate f285372k;

    @Deprecated(message = "please use TimePickerActionListener instead.", replaceWith = @ReplaceWith(expression = "TimePickerActionListener", imports = {}))
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\bg\u0018\u00002\u00020\u0001J:\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u0007H&¨\u0006\f"}, d2 = {"Lcom/larksuite/component/universe_design/timepicker/impl/action/UDTimePickerBuilder$TimePickerActonListener;", "", "onClickRightAction", "", "dialog", "Lcom/larksuite/component/universe_design/dialog/UDDialog;", BdpGameHostBaseUIService.DATE_PICKER_TYPE_YEAR, "", "monthOfYear", "dayOfMonth", "hourOfDay", "minute", "universe-ui-datepicker_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface TimePickerActonListener {
        void onClickRightAction(UDDialog r100, int r101, int r102, int r103, int r104, int r105);
    }

    public interface a {
        void a(UDDialog r100, int r101, int r102, int r103);
    }

    public UDTimePickerBuilder(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        this.f285362a = PickerModel.MONTHDAY_HOUR_MINUTE_24H;
        this.f285369h = 1;
        rootLayout(new UDTimePickerActionView(r100, null, 0, 6, null));
        controller(new com.larksuite.component.universe_design.timepicker.impl.action.a(r100));
        width(1.0f);
        gravity(80);
        marginInDp(0);
    }
}
