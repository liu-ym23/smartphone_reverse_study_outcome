package com.larksuite.component.universe_design.dialog;

import android.content.Context;
import androidx.exifinterface.media.ExifInterface;
import com.larksuite.component.universe_design.dialog.UDBaseListDialogBuilder;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0010\r\n\u0002\b\u000f\b'\u0018\u0000*\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u00002\b\u0012\u0004\u0012\u0002H\u00010\u0002:\u000278B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010'\u001a\u00028\u00002\f\u0010(\u001a\b\u0012\u0004\u0012\u00020*0)¢\u0006\u0002\u0010+J\u0019\u0010,\u001a\u00028\u00002\f\u0010(\u001a\b\u0012\u0004\u0012\u00020\u000f0)¢\u0006\u0002\u0010+J\u0013\u0010-\u001a\u00028\u00002\u0006\u0010.\u001a\u00020\u0013¢\u0006\u0002\u0010/J\u0013\u00100\u001a\u00028\u00002\u0006\u0010.\u001a\u00020\u0013¢\u0006\u0002\u0010/J\u0015\u00101\u001a\u00028\u00002\b\b\u0001\u0010.\u001a\u00020\u0013¢\u0006\u0002\u0010/J\u0015\u00102\u001a\u00028\u00002\b\b\u0001\u0010.\u001a\u00020\u0013¢\u0006\u0002\u0010/J\u0015\u00103\u001a\u00028\u00002\b\u0010.\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u00104J\u0013\u00105\u001a\u00028\u00002\u0006\u00105\u001a\u00020\"¢\u0006\u0002\u00106R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0013X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001e\u0010\u0018\u001a\u00020\u00138\u0000@\u0000X\u0081\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0015\"\u0004\b\u001a\u0010\u0017R\u001a\u0010\u001b\u001a\u00020\u0013X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0015\"\u0004\b\u001d\u0010\u0017R\u001e\u0010\u001e\u001a\u00020\u00138\u0000@\u0000X\u0081\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0015\"\u0004\b \u0010\u0017R\u001c\u0010!\u001a\u0004\u0018\u00010\"X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&¨\u00069"}, d2 = {"Lcom/larksuite/component/universe_design/dialog/UDBaseListDialogBuilder;", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/larksuite/component/universe_design/dialog/UDBaseDialogBuilder;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "mItemClickListener", "Lcom/larksuite/component/universe_design/dialog/UDListDialogController$OnItemClickListener;", "getMItemClickListener$universe_ui_dialog_release", "()Lcom/larksuite/component/universe_design/dialog/UDListDialogController$OnItemClickListener;", "setMItemClickListener$universe_ui_dialog_release", "(Lcom/larksuite/component/universe_design/dialog/UDListDialogController$OnItemClickListener;)V", "mItems", "", "Lcom/larksuite/component/universe_design/dialog/UDBaseListDialogBuilder$ListItem;", "getMItems$universe_ui_dialog_release", "()Ljava/util/List;", "mItemTextSize", "", "getMItemTextSize$universe_ui_dialog_release", "()I", "setMItemTextSize$universe_ui_dialog_release", "(I)V", "mItemTextColorRes", "getMItemTextColorRes$universe_ui_dialog_release", "setMItemTextColorRes$universe_ui_dialog_release", "mItemHeight", "getMItemHeight$universe_ui_dialog_release", "setMItemHeight$universe_ui_dialog_release", "mItemLayoutRes", "getMItemLayoutRes$universe_ui_dialog_release", "setMItemLayoutRes$universe_ui_dialog_release", "mAdapter", "Lcom/larksuite/component/universe_design/dialog/UDBaseListDialogAdapter;", "getMAdapter$universe_ui_dialog_release", "()Lcom/larksuite/component/universe_design/dialog/UDBaseListDialogAdapter;", "setMAdapter$universe_ui_dialog_release", "(Lcom/larksuite/component/universe_design/dialog/UDBaseListDialogAdapter;)V", "items", "values", "", "", "(Ljava/util/List;)Lcom/larksuite/component/universe_design/dialog/UDBaseListDialogBuilder;", "itemList", "itemTextSize", "value", "(I)Lcom/larksuite/component/universe_design/dialog/UDBaseListDialogBuilder;", "itemHeight", "itemTextColor", "itemLayout", "itemClickListener", "(Lcom/larksuite/component/universe_design/dialog/UDListDialogController$OnItemClickListener;)Lcom/larksuite/component/universe_design/dialog/UDBaseListDialogBuilder;", "adapter", "(Lcom/larksuite/component/universe_design/dialog/UDBaseListDialogAdapter;)Lcom/larksuite/component/universe_design/dialog/UDBaseListDialogBuilder;", "ListItemBuilder", "ListItem", "universe-ui-dialog_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class UDBaseListDialogBuilder<T extends UDBaseListDialogBuilder<T>> extends UDBaseDialogBuilder<T> {
    public static final int $stable = 8;
    private UDBaseListDialogAdapter mAdapter;
    private UDListDialogController.OnItemClickListener mItemClickListener;
    private int mItemHeight;
    private int mItemLayoutRes;
    private int mItemTextColorRes;
    private int mItemTextSize;
    private final List<ListItem> mItems;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\f\u001a\u00020\r8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0010\u001a\u00020\r8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0016\u0010\u0012\u001a\u00020\r8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000f¨\u0006\u0014"}, d2 = {"Lcom/larksuite/component/universe_design/dialog/UDBaseListDialogBuilder$ListItem;", "", "builder", "Lcom/larksuite/component/universe_design/dialog/UDBaseListDialogBuilder$ListItemBuilder;", "<init>", "(Lcom/larksuite/component/universe_design/dialog/UDBaseListDialogBuilder$ListItemBuilder;)V", "getBuilder", "()Lcom/larksuite/component/universe_design/dialog/UDBaseListDialogBuilder$ListItemBuilder;", "text", "", "getText", "()Ljava/lang/CharSequence;", "textColorRes", "", "getTextColorRes", "()I", "textColor", "getTextColor", "backgroundColorRes", "getBackgroundColorRes", "universe-ui-dialog_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class ListItem {
        public static final int $stable = 8;
        private final int backgroundColorRes;
        private final ListItemBuilder builder;
        private final CharSequence text;
        private final int textColor;
        private final int textColorRes;

        public final int getBackgroundColorRes() {
            return this.backgroundColorRes;
        }

        public final ListItemBuilder getBuilder() {
            return this.builder;
        }

        public final CharSequence getText() {
            return this.text;
        }

        public final int getTextColor() {
            return this.textColor;
        }

        public final int getTextColorRes() {
            return this.textColorRes;
        }

        public ListItem(ListItemBuilder r100) {
            Intrinsics.checkNotNullParameter(r100, "builder");
            this.builder = r100;
            this.text = r100.getText();
            this.textColorRes = r100.getTextColorRes();
            this.textColor = r100.getTextColor();
            this.backgroundColorRes = r100.getBackgroundColorRes();
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\r\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\t\u001a\u00020\u00002\b\b\u0001\u0010\u0015\u001a\u00020\nJ\u0010\u0010\u000f\u001a\u00020\u00002\b\b\u0001\u0010\u0016\u001a\u00020\nJ\u0010\u0010\u0012\u001a\u00020\u00002\b\b\u0001\u0010\u0015\u001a\u00020\nJ\u0006\u0010\u0017\u001a\u00020\u0018R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0005R\u001e\u0010\t\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001e\u0010\u000f\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000eR\u001e\u0010\u0012\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\f\"\u0004\b\u0014\u0010\u000e¨\u0006\u0019"}, d2 = {"Lcom/larksuite/component/universe_design/dialog/UDBaseListDialogBuilder$ListItemBuilder;", "", "text", "", "<init>", "(Ljava/lang/CharSequence;)V", "getText", "()Ljava/lang/CharSequence;", "setText", "textColorRes", "", "getTextColorRes", "()I", "setTextColorRes", "(I)V", "textColor", "getTextColor", "setTextColor", "backgroundColorRes", "getBackgroundColorRes", "setBackgroundColorRes", "colorRes", "color", "build", "Lcom/larksuite/component/universe_design/dialog/UDBaseListDialogBuilder$ListItem;", "universe-ui-dialog_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class ListItemBuilder {
        public static final int $stable = 8;
        private int backgroundColorRes;
        private CharSequence text;
        private int textColor;
        private int textColorRes;

        public final ListItem build() {
            return new ListItem(this);
        }

        public final int getBackgroundColorRes() {
            return this.backgroundColorRes;
        }

        public final CharSequence getText() {
            return this.text;
        }

        public final int getTextColor() {
            return this.textColor;
        }

        public final int getTextColorRes() {
            return this.textColorRes;
        }

        public ListItemBuilder(CharSequence r100) {
            Intrinsics.checkNotNullParameter(r100, "text");
            this.text = r100;
        }

        public final ListItemBuilder backgroundColorRes(int r100) {
            this.backgroundColorRes = r100;
            return this;
        }

        public final void setBackgroundColorRes(int r100) {
            this.backgroundColorRes = r100;
        }

        public final void setText(CharSequence r100) {
            Intrinsics.checkNotNullParameter(r100, "<set-?>");
            this.text = r100;
        }

        public final void setTextColor(int r100) {
            this.textColor = r100;
        }

        public final void setTextColorRes(int r100) {
            this.textColorRes = r100;
        }

        public final ListItemBuilder textColor(int r100) {
            this.textColor = r100;
            return this;
        }

        public final ListItemBuilder textColorRes(int r100) {
            this.textColorRes = r100;
            return this;
        }
    }

    public final UDBaseListDialogAdapter getMAdapter$universe_ui_dialog_release() {
        return this.mAdapter;
    }

    public final UDListDialogController.OnItemClickListener getMItemClickListener$universe_ui_dialog_release() {
        return this.mItemClickListener;
    }

    public final int getMItemHeight$universe_ui_dialog_release() {
        return this.mItemHeight;
    }

    public final int getMItemLayoutRes$universe_ui_dialog_release() {
        return this.mItemLayoutRes;
    }

    public final int getMItemTextColorRes$universe_ui_dialog_release() {
        return this.mItemTextColorRes;
    }

    public final int getMItemTextSize$universe_ui_dialog_release() {
        return this.mItemTextSize;
    }

    public final List<ListItem> getMItems$universe_ui_dialog_release() {
        return this.mItems;
    }

    public UDBaseListDialogBuilder(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        this.mItems = new ArrayList();
        this.mItemTextSize = -1;
        this.mItemTextColorRes = -1;
        this.mItemHeight = -1;
        this.mItemLayoutRes = -1;
        setMController$universe_ui_dialog_release(new UDListDialogController(r100));
        setMMarginInDp$universe_ui_dialog_release(12);
    }

    public final T adapter(UDBaseListDialogAdapter r100) {
        Intrinsics.checkNotNullParameter(r100, "adapter");
        this.mAdapter = r100;
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of com.larksuite.component.universe_design.dialog.UDBaseListDialogBuilder");
        return this;
    }

    public final T itemClickListener(UDListDialogController.OnItemClickListener r100) {
        this.mItemClickListener = r100;
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of com.larksuite.component.universe_design.dialog.UDBaseListDialogBuilder");
        return this;
    }

    public final T itemHeight(int r100) {
        this.mItemHeight = r100;
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of com.larksuite.component.universe_design.dialog.UDBaseListDialogBuilder");
        return this;
    }

    public final T itemLayout(int r100) {
        this.mItemLayoutRes = r100;
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of com.larksuite.component.universe_design.dialog.UDBaseListDialogBuilder");
        return this;
    }

    public final T itemList(List<ListItem> r100) {
        Intrinsics.checkNotNullParameter(r100, "values");
        this.mItems.clear();
        this.mItems.addAll(r100);
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of com.larksuite.component.universe_design.dialog.UDBaseListDialogBuilder");
        return this;
    }

    public final T itemTextColor(int r100) {
        this.mItemTextColorRes = r100;
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of com.larksuite.component.universe_design.dialog.UDBaseListDialogBuilder");
        return this;
    }

    public final T itemTextSize(int r100) {
        this.mItemTextSize = r100;
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of com.larksuite.component.universe_design.dialog.UDBaseListDialogBuilder");
        return this;
    }

    public final T items(List<? extends CharSequence> r100) {
        Intrinsics.checkNotNullParameter(r100, "values");
        this.mItems.clear();
        Iterator<T> r101 = r100.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        CharSequence r102 = (CharSequence) r101.next();
        this.mItems.add(new ListItemBuilder(r102).build());
        goto L4
    L6:
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of com.larksuite.component.universe_design.dialog.UDBaseListDialogBuilder");
        return this;
    }

    public final void setMAdapter$universe_ui_dialog_release(UDBaseListDialogAdapter r100) {
        this.mAdapter = r100;
    }

    public final void setMItemClickListener$universe_ui_dialog_release(UDListDialogController.OnItemClickListener r100) {
        this.mItemClickListener = r100;
    }

    public final void setMItemHeight$universe_ui_dialog_release(int r100) {
        this.mItemHeight = r100;
    }

    public final void setMItemLayoutRes$universe_ui_dialog_release(int r100) {
        this.mItemLayoutRes = r100;
    }

    public final void setMItemTextColorRes$universe_ui_dialog_release(int r100) {
        this.mItemTextColorRes = r100;
    }

    public final void setMItemTextSize$universe_ui_dialog_release(int r100) {
        this.mItemTextSize = r100;
    }
}
