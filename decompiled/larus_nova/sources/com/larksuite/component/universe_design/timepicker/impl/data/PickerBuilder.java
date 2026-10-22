package com.larksuite.component.universe_design.timepicker.impl.data;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001(B\u0013\u0012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u001e\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0005R\u001e\u0010\t\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0015\u001a\u00020\u0010X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0012R\u001a\u0010\u0017\u001a\u00020\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001c\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\f\"\u0004\b\u001e\u0010\u000eR\u001a\u0010\u001f\u001a\u00020\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0019\"\u0004\b!\u0010\u001bR\u001a\u0010\"\u001a\u00020#X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'¨\u0006)"}, d2 = {"Lcom/larksuite/component/universe_design/timepicker/impl/data/PickerBuilder;", "", "adapter", "Lcom/larksuite/component/universe_design/timepicker/impl/base/BaseWheelAdapter;", "<init>", "(Lcom/larksuite/component/universe_design/timepicker/impl/base/BaseWheelAdapter;)V", "getAdapter", "()Lcom/larksuite/component/universe_design/timepicker/impl/base/BaseWheelAdapter;", "setAdapter", "textColorCenter", "", "getTextColorCenter", "()I", "setTextColorCenter", "(I)V", "textSize", "", "getTextSize", "()F", "setTextSize", "(F)V", "outerTextSize", "getOuterTextSize", "isLoop", "", "()Z", "setLoop", "(Z)V", "visibleItemNum", "getVisibleItemNum", "setVisibleItemNum", "showTwoFigure", "getShowTwoFigure", "setShowTwoFigure", "layoutParams", "Lcom/larksuite/component/universe_design/timepicker/impl/data/PickerBuilder$LayoutParams;", "getLayoutParams", "()Lcom/larksuite/component/universe_design/timepicker/impl/data/PickerBuilder$LayoutParams;", "setLayoutParams", "(Lcom/larksuite/component/universe_design/timepicker/impl/data/PickerBuilder$LayoutParams;)V", "LayoutParams", "universe-ui-datepicker_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PickerBuilder {
    private e18.a<?> adapter;
    private boolean isLoop;
    private a layoutParams;
    private final float outerTextSize;
    private boolean showTwoFigure;
    private int textColorCenter;
    private float textSize;
    private int visibleItemNum;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public float f285394a;

        public a() {
            this.f285394a = 1.0f;
        }
    }

    public final e18.a<?> getAdapter() {
        return this.adapter;
    }

    public final a getLayoutParams() {
        return this.layoutParams;
    }

    public final float getOuterTextSize() {
        return this.outerTextSize;
    }

    public final boolean getShowTwoFigure() {
        return this.showTwoFigure;
    }

    public final int getTextColorCenter() {
        return this.textColorCenter;
    }

    public final float getTextSize() {
        return this.textSize;
    }

    public final int getVisibleItemNum() {
        return this.visibleItemNum;
    }

    public final boolean isLoop() {
        return this.isLoop;
    }

    public PickerBuilder(e18.a<?> r100) {
        Intrinsics.checkNotNullParameter(r100, "adapter");
        this.adapter = r100;
        this.textSize = 17.0f;
        this.outerTextSize = 14.0f;
        this.visibleItemNum = 3;
        this.layoutParams = new a();
    }

    public final void setAdapter(e18.a<?> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.adapter = r100;
    }

    public final void setLayoutParams(a r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.layoutParams = r100;
    }

    public final void setLoop(boolean r100) {
        this.isLoop = r100;
    }

    public final void setShowTwoFigure(boolean r100) {
        this.showTwoFigure = r100;
    }

    public final void setTextColorCenter(int r100) {
        this.textColorCenter = r100;
    }

    public final void setTextSize(float r100) {
        this.textSize = r100;
    }

    public final void setVisibleItemNum(int r100) {
        this.visibleItemNum = r100;
    }
}
