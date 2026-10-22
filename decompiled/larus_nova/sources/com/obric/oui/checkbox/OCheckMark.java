package com.obric.oui.checkbox;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.Checkable;
import androidx.appcompat.widget.AppCompatImageView;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002B\u0011\b\u0016\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nB\u0019\b\u0016\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\t\u0010\rB!\b\u0016\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\t\u0010\u0010J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¨\u0006\u0011"}, d2 = {"Lcom/obric/oui/checkbox/OCheckMark;", "Landroidx/appcompat/widget/AppCompatImageView;", "Landroid/widget/Checkable;", "", "checked", "", "setChecked", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0})
public class OCheckMark extends AppCompatImageView implements Checkable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Drawable f399399a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f399400b;

    public final void init() {
        setMinimumWidth(this.f399399a.getMinimumWidth());
        setMinimumHeight(this.f399399a.getMinimumHeight());
        setBackgroundDrawable(this.f399399a);
    }

    @Override // android.widget.Checkable
    public final void toggle() {
        setChecked(!this.f399400b);
    }

    @Override // android.widget.Checkable
    public final boolean isChecked() {
        return this.f399400b;
    }

    public OCheckMark(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        this.f399399a = getResources().getDrawable(R.drawable.o_card_list_item_tail_icon_mark);
        this.f399400b = true;
        init();
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean r100) {
        if (this.f399400b != r100) goto L5;
        return;
    L5:
        this.f399400b = r100;
        if (r100 == false) goto L8;
        Drawable r101 = this.f399399a;
    L9:
        setBackgroundDrawable(r101);
        invalidate();
        return;
    L8:
        r101 = null;
        goto L9
    }

    public OCheckMark(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "attrs");
        super(r100, r101);
        this.f399399a = getResources().getDrawable(R.drawable.o_card_list_item_tail_icon_mark);
        this.f399400b = true;
        init();
    }

    public OCheckMark(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "attrs");
        super(r100, r101, r102);
        this.f399399a = getResources().getDrawable(R.drawable.o_card_list_item_tail_icon_mark);
        this.f399400b = true;
        init();
    }
}
