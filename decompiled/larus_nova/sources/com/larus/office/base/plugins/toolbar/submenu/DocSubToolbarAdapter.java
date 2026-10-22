package com.larus.office.base.plugins.toolbar.submenu;

import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.android.ec.model.response.ECPromotion;
import com.google.gson.Gson;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.im.internal.delegate.c0;
import com.larus.nova.R;
import com.larus.office.base.plugins.toolbar.model.Item;
import com.larus.office.base.plugins.toolbar.view.RoundedView;
import com.larus.utils.logger.FLogger;
import com.larus.utils.p0;
import en9.k;
import in9.d;
import kn9.l;
import kn9.m;
import kn9.n;
import kn9.o;
import kn9.p;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;
import v19.h;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0016\u0018\u0000 .2\u00020\u0001:\u0007()*+,-.B\u0017\u0012\u000e\u0010\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u0010H\u0016J\u0010\u0010\u0015\u001a\u00020\u00122\b\u0010\u0007\u001a\u0004\u0018\u00010\bJ\u0010\u0010\u0016\u001a\u00020\u00122\b\u0010\u0017\u001a\u0004\u0018\u00010\nJ\u0018\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0004H\u0002J\u001a\u0010\u001c\u001a\u00020\u00102\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\u001a\u0010\u001f\u001a\u00020\u00122\b\u0010\u0019\u001a\u0004\u0018\u00010 2\u0006\u0010\u001b\u001a\u00020\u0004H\u0002J\u0018\u0010!\u001a\u00020\u00122\u0006\u0010\u0019\u001a\u00020\"2\u0006\u0010\u001b\u001a\u00020\u0004H\u0002J\u0018\u0010#\u001a\u00020\u00122\u0006\u0010\u0019\u001a\u00020$2\u0006\u0010\u001b\u001a\u00020\u0004H\u0002J\u0018\u0010%\u001a\u00020\u00122\u0006\u0010\u0019\u001a\u00020&2\u0006\u0010\u001b\u001a\u00020\u0004H\u0002J\u0010\u0010'\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u0010H\u0016R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006/"}, d2 = {"Lcom/larus/office/base/plugins/toolbar/submenu/DocSubToolbarAdapter;", "Lcom/larus/office/base/plugins/toolbar/submenu/BaseSubToolbarAdapter;", "items", "", "Lcom/larus/office/base/plugins/toolbar/model/Item;", "<init>", "([Lcom/larus/office/base/plugins/toolbar/model/Item;)V", "mOnHighlightItemClickListener", "Lcom/larus/office/base/plugins/toolbar/submenu/DocSubToolbarAdapter$OnHighlightItemClickListener;", "mOnStartFontSizeFragmentListener", "Lcom/larus/office/base/plugins/toolbar/submenu/DocSubToolbarAdapter$OnStartFontSizeFragmentListener;", "onCreateViewHolder", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "parent", "Landroid/view/ViewGroup;", "viewType", "", "onBindViewHolder", "", "holder", "position", "setOnHighlightItemClickListener", "setOnStartFontSizeFragmentListener", "onStartFontSizeFragmentListener", "bindNewHighlight", "viewHolder", "Lcom/larus/office/base/plugins/toolbar/submenu/DocSubToolbarAdapter$HighlightViewHolder;", MapController.ITEM_LAYER_TAG, "parseColor", "colorRgba", "Lcom/larus/office/base/plugins/toolbar/selector/Highlight$ColorRgba;", "bindOldHighlight", "Lcom/larus/office/base/plugins/toolbar/submenu/BaseSubToolbarAdapter$TextColorViewHolder;", "bindFontSize", "Lcom/larus/office/base/plugins/toolbar/submenu/DocSubToolbarAdapter$FontSizeViewHolder;", "bindFontColor", "Lcom/larus/office/base/plugins/toolbar/submenu/DocSubToolbarAdapter$FontColorViewHolder;", "bindFontPicker", "Lcom/larus/office/base/plugins/toolbar/submenu/DocSubToolbarAdapter$FontPickerViewHolder;", "getItemViewType", "OnHighlightItemClickListener", "OnStartFontSizeFragmentListener", "HighlightViewHolder", "FontSizeViewHolder", "FontColorViewHolder", "FontPickerViewHolder", "Companion", "base_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class DocSubToolbarAdapter extends BaseSubToolbarAdapter {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ int f360953e = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public b f360954c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public c f360955d;

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"Lcom/larus/office/base/plugins/toolbar/submenu/DocSubToolbarAdapter$FontColorViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "mFontColorIcon", "Landroid/widget/ImageView;", "getMFontColorIcon", "()Landroid/widget/ImageView;", "setMFontColorIcon", "(Landroid/widget/ImageView;)V", "mFontColorIndicator", "Lcom/larus/office/base/plugins/toolbar/view/RoundedView;", "getMFontColorIndicator", "()Lcom/larus/office/base/plugins/toolbar/view/RoundedView;", "setMFontColorIndicator", "(Lcom/larus/office/base/plugins/toolbar/view/RoundedView;)V", "mFontColorLayout", "Landroid/view/ViewGroup;", "getMFontColorLayout", "()Landroid/view/ViewGroup;", "setMFontColorLayout", "(Landroid/view/ViewGroup;)V", "base_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class FontColorViewHolder extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final RoundedView f360956a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final ViewGroup f360957b;

        public FontColorViewHolder(View r100) {
            Intrinsics.checkNotNullParameter(r100, "itemView");
            super(r100);
            this.f360957b = (ViewGroup) r100.findViewById(R.id.sub_toolbar_item_font_color_layout);
            ImageView r101 = (ImageView) r100.findViewById(R.id.sub_toolbar_item_font_color_icon);
            this.f360956a = (RoundedView) r100.findViewById(R.id.sub_toolbar_item_font_color_indicator);
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"Lcom/larus/office/base/plugins/toolbar/submenu/DocSubToolbarAdapter$FontPickerViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "mFontPickerText", "Landroid/widget/TextView;", "getMFontPickerText", "()Landroid/widget/TextView;", "setMFontPickerText", "(Landroid/widget/TextView;)V", "mFontPickerIcon", "Landroidx/appcompat/widget/AppCompatImageView;", "getMFontPickerIcon", "()Landroidx/appcompat/widget/AppCompatImageView;", "setMFontPickerIcon", "(Landroidx/appcompat/widget/AppCompatImageView;)V", "mFontPickerLayout", "Landroid/view/ViewGroup;", "getMFontPickerLayout", "()Landroid/view/ViewGroup;", "setMFontPickerLayout", "(Landroid/view/ViewGroup;)V", "base_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class FontPickerViewHolder extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final TextView f360958a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final AppCompatImageView f360959b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final ViewGroup f360960c;

        public FontPickerViewHolder(View r100) {
            Intrinsics.checkNotNullParameter(r100, "itemView");
            super(r100);
            this.f360958a = (TextView) r100.findViewById(R.id.font_picker_text);
            this.f360959b = (AppCompatImageView) r100.findViewById(R.id.font_picker_icon);
            this.f360960c = (ViewGroup) r100.findViewById(R.id.font_picker_layout);
        }
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/larus/office/base/plugins/toolbar/submenu/DocSubToolbarAdapter$FontSizeViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "mFontSizeText", "Landroid/widget/TextView;", "getMFontSizeText", "()Landroid/widget/TextView;", "setMFontSizeText", "(Landroid/widget/TextView;)V", "base_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class FontSizeViewHolder extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final TextView f360961a;

        public FontSizeViewHolder(View r100) {
            Intrinsics.checkNotNullParameter(r100, "itemView");
            super(r100);
            this.f360961a = (TextView) r100.findViewById(R.id.sub_toolbar_item_font_size);
        }
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0012\b\u0004\u0018\u00002\u00020\u0001B\u0011\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\t\"\u0004\b\u000e\u0010\u000bR\u001a\u0010\u000f\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0005R\u001a\u0010\u0013\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0011\"\u0004\b\u0015\u0010\u0005R\u001a\u0010\u0016\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0011\"\u0004\b\u0018\u0010\u0005¨\u0006\u0019"}, d2 = {"Lcom/larus/office/base/plugins/toolbar/submenu/DocSubToolbarAdapter$HighlightViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "mIcon", "Landroid/widget/ImageView;", "getMIcon", "()Landroid/widget/ImageView;", "setMIcon", "(Landroid/widget/ImageView;)V", "mAllow", "getMAllow", "setMAllow", "mParentView", "getMParentView", "()Landroid/view/View;", "setMParentView", "mSelectedView", "getMSelectedView", "setMSelectedView", "mOpenPanel", "getMOpenPanel", "setMOpenPanel", "base_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class HighlightViewHolder extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ImageView f360962a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final View f360963b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final View f360964c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final View f360965d;

        public static final class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ HighlightViewHolder f360966a;

            public final void a() {
                Rect r100 = new Rect(this.f360966a.f360962a.getRight(), this.f360966a.f360962a.getTop(), this.f360966a.f360963b.getRight(), this.f360966a.f360963b.getBottom());
                this.f360966a.f360963b.setTouchDelegate(new TouchDelegate(r100, this.f360966a.f360965d));
            }

            @Override // java.lang.Runnable
            public final void run() {
                a();     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }

            public a(HighlightViewHolder r100) {
                this.f360966a = r100;
            }
        }

        public HighlightViewHolder(View r100) {
            Intrinsics.checkNotNullParameter(r100, "itemView");
            super(r100);
            ImageView r101 = (ImageView) r100.findViewById(R.id.sub_toolbar_item_icon);
            this.f360962a = r101;
            ImageView r102 = (ImageView) r100.findViewById(R.id.allow);
            View r103 = r100.findViewById(R.id.parent);
            this.f360963b = r103;
            this.f360964c = r100.findViewById(R.id.selected);
            this.f360965d = r100.findViewById(R.id.openPanel);
            r103.post(new a(this));
            r101.bringToFront();
            r102.bringToFront();
        }
    }

    public static final class a {
    }

    public interface b {
        void a(Item r100, boolean r101);
    }

    public interface c {
        void a(View r100, String r101);
    }

    static {
    }

    public DocSubToolbarAdapter(Item[] r100) {
        Intrinsics.checkNotNullParameter(r100, "items");
        super(r100);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemViewType(int r100) {
        Item r101 = this.f360938a[r100];
        if (r101 != null) goto L5;
        return 0;
    L5:
        if (Intrinsics.areEqual("separator", r101.getId()) == false) goto L9;
        return 1;
    L9:
        if (Intrinsics.areEqual("oldHighlight", r101.id().itemName()) == false) goto L13;
        return 4;
    L13:
        if (Intrinsics.areEqual("highlight", r101.id().itemName()) == false) goto L17;
        return 6;
    L17:
        if (Intrinsics.areEqual("fontSize", r101.id().itemName()) == false) goto L21;
        return 7;
    L21:
        if (Intrinsics.areEqual("fontName", r101.id().itemName()) == false) goto L25;
        return 9;
    L25:
        if (Intrinsics.areEqual("fontColor", r101.id().itemName()) == false) goto L30;
        return 8;
    L30:
        return 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.larus.office.base.plugins.toolbar.submenu.BaseSubToolbarAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r110, int r111) {
        Intrinsics.checkNotNullParameter(r110, "holder");
        super.onBindViewHolder(r110, r111);
        if ((r110 instanceof BaseSubToolbarAdapter.DividerViewHolder) == false) goto L5;
        return;
    L5:
        final Item r112 = this.f360938a[r111];
        if (r112 == null) goto L134;
        JSONObject r100 = null;
        if (Intrinsics.areEqual("highlight", r112.getId()) == false) goto L19;
        r110.itemView.setOnClickListener(null);
        HighlightViewHolder r113 = (HighlightViewHolder) r110;
        r113.f360962a.setImageResource(p.a(r112.id()));
        String r101 = r112.getValue();
        if (TextUtils.isEmpty(r101) == false) goto L12;
        FLogger.f375446a.w("DocSubToolbarAdapter", "bind highlight but value is empty");
        return;
    L12:
        jn9.a r102 = new jn9.a();
        r102 = (jn9.a) new Gson().fromJson(r101, jn9.a.class);     // Catch: Exception -> L15
    L17:
        FLogger.f375446a.i("DocSubToolbarAdapter", "item is selected " + r112.isSelected() + " highlight: =" + r102);
        r113.f360964c.setSelected(r112.isSelected());
        r113.f360963b.setOnClickListener(new m(this, r112));
        r113.f360965d.setOnClickListener(new n(this, r112));
        r102.getClass();
        r113.f360962a.setBackground(null);
        ImageView r114 = r113.f360962a;
        r114.setColorFilter(r114.getResources().getColor(R.color.icon_n1));
        return;
    L15:
        e = move-exception;
        FLogger.f375446a.e("Selected", e.getMessage());
        goto L17
    L19:
        if (Intrinsics.areEqual("fontSize", r112.getId()) == false) goto L28;
        final FontSizeViewHolder r115 = (FontSizeViewHolder) r110;
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L23
        int r104 = p0.f375454a;     // Catch: Throwable -> L23
        JSONObject r105 = p0.b(r112.getValue());     // Catch: Throwable -> L23
        r115.f360961a.setText(r105.optString("value") + r105.optString("extra"));     // Catch: Throwable -> L23
        r115.f360961a.setOnClickListener(new l(r115, this, r112));     // Catch: Throwable -> L23
        Object r116 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L23
    L25:
        Throwable r117 = Result.m9452exceptionOrNullimpl(r116);
        if (r117 == null) goto L137;
        FLogger.f375446a.w("DocSubToolbarAdapter", "bindFontPicker: " + r117.getMessage());
        return;
    L137:
        return;
    L23:
        th = move-exception;
        Result.Companion r118 = Result.Companion;
        r116 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L25
    L28:
        boolean r106 = true;
        int r107 = 0;
        if (Intrinsics.areEqual("fontColor", r112.id().itemName()) == false) goto L83;
        FontColorViewHolder r119 = (FontColorViewHolder) r110;
        Ref.ObjectRef r108 = new Ref.ObjectRef();
        Result.Companion r109 = Result.Companion;     // Catch: Throwable -> L69
        int r120 = p0.f375454a;     // Catch: Throwable -> L69
        Object r121 = p0.b(r112.getValue()).opt("value");     // Catch: Throwable -> L69
        if ((r121 instanceof JSONArray) == false) goto L34;
        JSONArray r122 = (JSONArray) r121;     // Catch: Throwable -> L69
    L35:
        if (r122 != null) goto L37;
        Unit r123 = null;
    L67:
        Object r124 = Result.m9449constructorimpl(r123);     // Catch: Throwable -> L69
    L71:
        Throwable r125 = Result.m9452exceptionOrNullimpl(r124);
        if (r125 == null) goto L74;
        FLogger.f375446a.e("DocSubToolbarAdapter", "bindFontColor: error:" + r125);
        return;
    L74:
        d r126 = (d) r108.element;
        if (r126 != null) goto L77;
        return;
    L77:
        if (Intrinsics.areEqual(r126.getType(), ECPromotion.TRANSPARENT_BOTTON_ICON) == false) goto L81;
        r119.f360956a.setColor(-16777216);
        boolean r127 = h.f552477a;
        if (h.a(null) == false) goto L141;
        r119.f360956a.setBoard(true);
        return;
    L141:
        return;
    L81:
        k r128 = k.f473226a;
        RoundedView r129 = r119.f360956a;
        r128.getClass();
        k.a(r129, r126);
        RoundedView r130 = r119.f360956a;
        r130.setBoard(k.c(r130.getContext(), r126));
        return;
    L37:
        int r131 = r122.length();     // Catch: Throwable -> L69
    L38:
        if (r107 >= r131) goto L45;
        JSONObject r132 = r122.optJSONObject(r107);     // Catch: Throwable -> L69
        if (r132 == null) goto L44;
        if (Intrinsics.areEqual(r132.optString("key"), "textColor") == false) goto L44;
    L46:
        if (r132 == null) goto L65;
        Object r133 = r132.opt("value");     // Catch: Throwable -> L69
        if (r133 == null) goto L65;
        String r134 = r133.toString();     // Catch: Throwable -> L69
        if (r134 == null) goto L65;
        zd9.h r135 = zd9.h.f571481a;     // Catch: Throwable -> L69
        if (StringsKt.isBlank(r134) == false) goto L122;
    L63:
        Object r136 = null;
    L64:
        T r137 = (d) r136;     // Catch: Throwable -> L69
    L66:
        r108.element = r137;     // Catch: Throwable -> L69
        r123 = Unit.INSTANCE;     // Catch: Throwable -> L69
        goto L67
    L122:
        Result.Companion r138 = Result.Companion;     // Catch: Throwable -> L56
        r135.getClass();     // Catch: Throwable -> L56
        r136 = Result.m9449constructorimpl(zd9.h.f571482b.fromJson(r134, new o().getType()));     // Catch: Throwable -> L56
    L58:
        Throwable r139 = Result.m9452exceptionOrNullimpl(r136);     // Catch: Throwable -> L69
        if (r139 == null) goto L62;
        c0 r140 = c0.f348199b;     // Catch: Throwable -> L69
        StringBuilder r141 = new StringBuilder();     // Catch: Throwable -> L69
        r141.append("fromJson failed, stack: ");     // Catch: Throwable -> L69
        Intrinsics.checkNotNullParameter(r139, "<this>");     // Catch: Throwable -> L69
        r141.append(ExceptionsKt.stackTraceToString(r139));     // Catch: Throwable -> L69
        r140.e("GsonHolder", r141.toString());     // Catch: Throwable -> L69
    L62:
        if (Result.m9455isFailureimpl(r136) == false) goto L64;
    L56:
        th = move-exception;
        Result.Companion r142 = Result.Companion;     // Catch: Throwable -> L69
        r136 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L69
    L65:
        r137 = 0;
    L44:
        r107 = r107 + 1;     // Catch: Throwable -> L69
        goto L38
    L45:
        r132 = null;
        goto L46
    L34:
        r122 = null;
    L69:
        th = move-exception;
        Result.Companion r143 = Result.Companion;
        r124 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L71
    L83:
        if (Intrinsics.areEqual("fontName", r112.id().itemName()) == false) goto L103;
        FontPickerViewHolder r144 = (FontPickerViewHolder) r110;
        Result.Companion r145 = Result.Companion;     // Catch: Throwable -> L97
        int r146 = p0.f375454a;     // Catch: Throwable -> L97
        JSONObject r147 = p0.b(r112.getValue()).optJSONObject("value");     // Catch: Throwable -> L97
        if (r147 == null) goto L95;
        String r148 = r147.optString("name");     // Catch: Throwable -> L97
        if (r148 != null) goto L90;
        r148 = "";
    L90:
        r144.f360958a.setText(r148);     // Catch: Throwable -> L97
        boolean r149 = r147.optBoolean("isSupport");     // Catch: Throwable -> L97
        FLogger.f375446a.d("DocSubToolbarAdapter", "bindFontPicker() called name:" + r148 + " enable:" + r149);     // Catch: Throwable -> L97
        if (r149 == false) goto L93;
        TextView r150 = r144.f360958a;     // Catch: Throwable -> L97
        r150.setTextColor(r150.getResources().getColor(R.color.larus_neutral_100));     // Catch: Throwable -> L97
        r144.f360959b.setVisibility(8);     // Catch: Throwable -> L97
    L94:
        r100 = r147;
        goto L95
    L93:
        TextView r151 = r144.f360958a;     // Catch: Throwable -> L97
        r151.setTextColor(r151.getResources().getColor(R.color.text_disable));     // Catch: Throwable -> L97
        r144.f360959b.setVisibility(0);     // Catch: Throwable -> L97
    L95:
        Object r152 = Result.m9449constructorimpl(r100);     // Catch: Throwable -> L97
    L99:
        Throwable r153 = Result.m9452exceptionOrNullimpl(r152);
        if (r153 == null) goto L144;
        FLogger.f375446a.w("DocSubToolbarAdapter", "bindFontPicker: " + r153.getMessage());
        return;
    L144:
        return;
    L97:
        th = move-exception;
        Result.Companion r154 = Result.Companion;
        r152 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L99
    L103:
        if (Intrinsics.areEqual("oldHighlight", r112.id().itemName()) == false) goto L108;
        BaseSubToolbarAdapter.TextColorViewHolder r155 = (BaseSubToolbarAdapter.TextColorViewHolder) r110;
        String r156 = r112.getValue();
        if (TextUtils.isEmpty(r156) == false) goto L107;
        FLogger.f375446a.w("DocSubToolbarAdapter", "bind old highlight but value is empty");
        return;
    L107:
        FLogger.f375446a.i("DocSubToolbarAdapter", "color: " + r156);
        return;
    L108:
        BaseSubToolbarAdapter.SubToolbarViewHolder r157 = (BaseSubToolbarAdapter.SubToolbarViewHolder) r110;
        int r158 = p.a(r112.id());
        Intrinsics.checkNotNullParameter(r157, "subToolbarViewHolder");
        Intrinsics.checkNotNullParameter(r112, MapController.ITEM_LAYER_TAG);
        ImageView r159 = r157.f360940a;
        r159.setImageTintList(r159.getResources().getColorStateList(R.color.larus_toolbar_item_tint));
        r157.f360940a.setImageResource(r158);
        ImageView r160 = r157.f360940a;
        if (r112.isEnable() == true) goto L111;
    L113:
        r106 = false;
    L114:
        r160.setSelected(r106);
        r157.f360940a.setEnabled(r112.isEnable());
        ImageView r161 = r157.f360940a;
        if (r112.isEnable() == false) goto L117;
        Drawable r162 = r157.f360940a.getResources().getDrawable(R.drawable.larus_doc_toolbar_v2_subitem_all_selector).mutate();
    L118:
        r161.setBackground(r162);
        r157.f360940a.setColorFilter(null);
        return;
    L117:
        r162 = null;
        goto L118
    L111:
        if (r112.isSelected() == false) goto L113;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        if (r101 == 1) goto L20;
        if (r101 == 4) goto L18;
        switch(r101) {
            case 6: goto L16;
            case 7: goto L14;
            case 8: goto L12;
            case 9: goto L10;
            default: goto L8;
        };
    L8:
        return new BaseSubToolbarAdapter.SubToolbarViewHolder(LayoutInflater.from(r100.getContext()).inflate(R.layout.larus_doc_sub_toolbar_item_horizontal, r100, false));
    L10:
        return new FontPickerViewHolder(LayoutInflater.from(r100.getContext()).inflate(R.layout.larus_doc_sub_toolbar_item_font_picker, r100, false));
    L12:
        return new FontColorViewHolder(LayoutInflater.from(r100.getContext()).inflate(R.layout.larus_doc_sub_toolbar_item_font_color, r100, false));
    L14:
        return new FontSizeViewHolder(LayoutInflater.from(r100.getContext()).inflate(R.layout.larus_doc_sub_toolbar_item_font_size, r100, false));
    L16:
        return new HighlightViewHolder(LayoutInflater.from(r100.getContext()).inflate(R.layout.larus_doc_sub_toolbar_item_highlight, r100, false));
    L18:
        return new BaseSubToolbarAdapter.TextColorViewHolder(LayoutInflater.from(r100.getContext()).inflate(R.layout.larus_doc_sub_toolbar_item_text_color, r100, false));
    L20:
        return new BaseSubToolbarAdapter.DividerViewHolder(LayoutInflater.from(r100.getContext()).inflate(R.layout.larus_doc_sub_toolbar_item_divider, r100, false));
    }
}
