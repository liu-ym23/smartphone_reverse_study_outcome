package com.larksuite.component.card.plugin.select;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.component.card.plugin.model.UniversalCardShowSelectMenuPluginModel$IconModel;
import com.larksuite.component.card.plugin.model.UniversalCardShowSelectMenuPluginModel$OptionsItemModel;
import com.larksuite.component.ui.imageview.LKUIRoundedImageView2;
import com.larksuite.component.universe_design.checkbox.UDCheckBox;
import com.larksuite.component.universe_design.color.UDColorUtils;
import com.larksuite.component.universe_design.dialog.UDBaseListDialogAdapter;
import com.larksuite.component.universe_design.icon.UDIconUtils;
import com.larus.nova.R;
import com.ss.android.lark.appreciablelib.Biz;
import com.ss.android.lark.component.appcontext.LarkAppContext;
import com.ss.android.lark.image.ImageLoader;
import com.ss.android.lark.image.api.IRequestCreator;
import com.ss.android.lark.image.entity.EncryptImage;
import com.ss.android.lark.image.entity.ListenerParams;
import com.ss.android.lark.image.impl.PerfLoadPicMonitor;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001:\u0001#B@\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005\u0012%\u0010\u0006\u001a!\u0012\u0015\u0012\u0013\u0018\u00010\b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0007¢\u0006\u0004\b\f\u0010\rJ\u0018\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0005H\u0016J\u0018\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u00182\u0006\u0010\u001f\u001a\u00020\u0005H\u0016J\u0018\u0010 \u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020\u00052\u0006\u0010!\u001a\u00020\"H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R-\u0010\u0006\u001a!\u0012\u0015\u0012\u0013\u0018\u00010\b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006$"}, d2 = {"Lcom/larksuite/component/card/plugin/select/SelectMenuAdapter;", "Lcom/larksuite/component/universe_design/dialog/UDBaseListDialogAdapter;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "resource", "", "getImageKey", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "imageID", "<init>", "(Landroid/content/Context;ILkotlin/jvm/functions/Function1;)V", "getContext", "()Landroid/content/Context;", "options", "", "Lcom/larksuite/component/card/plugin/model/UniversalCardShowSelectMenuPluginModel$OptionsItemModel;", "getOptions", "()Ljava/util/List;", "setOptions", "(Ljava/util/List;)V", "onCreateViewHolder", "Lcom/larksuite/component/universe_design/dialog/UDBaseListDialogAdapter$UDDialogListItemViewHolder;", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "", "holder", "position", "initCheckBox", "viewHolder", "Lcom/larksuite/component/card/plugin/select/SelectMenuAdapter$ItemViewHolder;", "ItemViewHolder", "universalcard_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class SelectMenuAdapter extends UDBaseListDialogAdapter {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Context f283818i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f283819j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Function1<String, String> f283820k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public List<? extends UniversalCardShowSelectMenuPluginModel$OptionsItemModel> f283821l;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/larksuite/component/card/plugin/select/SelectMenuAdapter$ItemViewHolder;", "Lcom/larksuite/component/universe_design/dialog/UDBaseListDialogAdapter$UDDialogListItemViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "icon", "Lcom/larksuite/component/ui/imageview/LKUIRoundedImageView2;", "getIcon", "()Lcom/larksuite/component/ui/imageview/LKUIRoundedImageView2;", "checkBox", "Lcom/larksuite/component/universe_design/checkbox/UDCheckBox;", "getCheckBox", "()Lcom/larksuite/component/universe_design/checkbox/UDCheckBox;", "universalcard_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class ItemViewHolder extends UDBaseListDialogAdapter.UDDialogListItemViewHolder {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final LKUIRoundedImageView2 f283822b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final UDCheckBox f283823c;

        public ItemViewHolder(View r100) {
            Intrinsics.checkNotNullParameter(r100, "itemView");
            super(r100);
            this.f283822b = (LKUIRoundedImageView2) r100.findViewById(R.id.ud_dialog_icon);
            this.f283823c = (UDCheckBox) r100.findViewById(R.id.ud_dialog_content_item_cb);
        }
    }

    public final Context getContext() {
        return this.f283818i;
    }

    public void B2(int r100, ItemViewHolder r101) {
        Intrinsics.checkNotNullParameter(r101, "viewHolder");
        if (((UniversalCardShowSelectMenuPluginModel$OptionsItemModel) ListProtector.get(this.f283821l, r100)).isSelected == false) goto L5;
        UDCheckBox r102 = r101.f283823c;
        r102.setVisibility(0);
        r102.setChecked(true);
        return;
    L5:
        UDCheckBox r103 = r101.f283823c;
        r103.setVisibility(8);
        r103.setChecked(false);
    }

    @Override // com.larksuite.component.universe_design.dialog.UDBaseListDialogAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public final /* bridge */ /* synthetic */ void onBindViewHolder(RecyclerView.ViewHolder r100, int r101) {
        y2((UDBaseListDialogAdapter.UDDialogListItemViewHolder) r100, r101);
    }

    @Override // com.larksuite.component.universe_design.dialog.UDBaseListDialogAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public final /* bridge */ /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        return z2(r100, r101);
    }

    @Override // com.larksuite.component.universe_design.dialog.UDBaseListDialogAdapter
    public final void y2(UDBaseListDialogAdapter.UDDialogListItemViewHolder r110, int r210) {
        Intrinsics.checkNotNullParameter(r110, "holder");
        super.y2(r110, r210);
        if ((r110 instanceof ItemViewHolder) == false) goto L5;
        ItemViewHolder r100 = (ItemViewHolder) r110;
    L6:
        if (r100 == null) goto L78;
        r100.f283822b.setVisibility(8);
        if (this.f283821l.size() <= r210) goto L74;
        UniversalCardShowSelectMenuPluginModel$IconModel r101 = ((UniversalCardShowSelectMenuPluginModel$OptionsItemModel) ListProtector.get(this.f283821l, r210)).icon;
        if (r101 == null) goto L14;
        String r102 = r101.token;
        if (r102 == null) goto L14;
        boolean r103 = StringsKt.endsWith$default(r102, "colorful", false, 2, null);
    L15:
        if (r101 == null) goto L17;
        String r104 = r101.token;
    L18:
        if (r104 != null) goto L20;
    L23:
        boolean r105 = true;
    L24:
        if (r105 == false) goto L26;
        int r106 = 0;
    L28:
        if (r106 == 0) goto L60;
        r100.f283822b.setVisibility(0);
        LKUIRoundedImageView2 r111 = r100.f283822b;
        r111.setVisibility(0);
        if (r101 == null) goto L32;
        String r112 = r101.color;
    L33:
        if (r101 == null) goto L35;
        String r107 = r101.customColor;
    L36:
        Intrinsics.checkNotNullParameter(r111, "<this>");
        if (r103 == false) goto L76;
        Drawable r108 = UDIconUtils.getIconDrawable(r111.getContext(), r106);
    L59:
        r111.setImageDrawable(r108);
        goto L74
    L76:
        Integer r109 = Integer.valueOf(Color.parseColor(r107));     // Catch: Exception -> L40
    L42:
        if (r109 == null) goto L44;
        r108 = UDIconUtils.getIconDrawable(r111.getContext(), r106, r109.intValue());
        goto L59
    L44:
        if (r112 != null) goto L46;
    L57:
        r108 = UDIconUtils.getIconDrawable(r111.getContext(), r106);
        goto L59
    L46:
        if (Intrinsics.areEqual(r112, "icon-disabled") == false) goto L48;
        r112 = "icon-disable";
    L48:
        String r113 = r112;
        int r114 = UDColorUtils.getColorIdByToken(r111.getContext(), r113);
        if (r114 == 0) goto L51;
    L53:
        if (r114 == 0) goto L55;
        r108 = UDIconUtils.getIconDrawable(r111.getContext(), r106, r111.getContext().getResources().getColor(r114));
    L56:
        if (r108 != null) goto L59;
    L55:
        r108 = UDIconUtils.getIconDrawable(r111.getContext(), r106);
        goto L56
    L51:
        if (StringsKt.startsWith$default(r113, "ud", false, 2, null) == true) goto L53;
        r114 = UDColorUtils.getColorIdByToken(r111.getContext(), "ud_" + StringsKt.replace$default(r113, "-", "_", false, 4, null));
    L40:
        e = move-exception;
        Log.e("SelectMenuItemHelper", e);
        r109 = null;
        goto L42
    L35:
        r107 = null;
        goto L36
    L32:
        r112 = null;
        goto L33
    L60:
        if (r101 == null) goto L62;
        String r115 = r101.imageID;
    L64:
        if (TextUtils.isEmpty(r115) == true) goto L74;
        Function1<String, String> r116 = this.f283820k;
        if (r101 == null) goto L68;
        String r117 = r101.imageID;
    L69:
        String r118 = r116.invoke(r117);
        if (r118 == null) goto L72;
        LKUIRoundedImageView2 r119 = r100.f283822b;
        r119.setVisibility(0);
        Context r120 = r119.getContext();
        Intrinsics.checkNotNullParameter(r119, "<this>");
        Intrinsics.checkNotNullParameter(r120, PerfLog.PARAM_KEY_CONTEXT_ID);
        IRequestCreator r121 = ImageLoader.with(r120).load(new EncryptImage(r118));
        r121.centerCrop();
        r119.setScaleType(ImageView.ScaleType.FIT_CENTER);
        IRequestCreator r122 = r121.dontAnimate(false);
        ListenerParams.a r123 = new ListenerParams.a();
        r123.a(Biz.Messenger);
        r123.c(ListenerParams.FromType.CARD);
        r123.f426326o = r118;
        r122.listener(new PerfLoadPicMonitor.MonitorRequestListener(r123.b())).into(r119);
        goto L74
    L72:
        LKUIRoundedImageView2 r124 = r100.f283822b;
        Intrinsics.checkNotNullParameter(r124, "<this>");
        r124.setImageDrawable(null);
        ImageLoader.clear(r124);
        return;
    L68:
        r117 = null;
        goto L69
    L62:
        r115 = null;
        goto L64
    L26:
        int r125 = com.larksuite.component.card.utils.d.f283980a;
        LarkAppContext.Companion.getClass();
        r106 = com.larksuite.component.card.utils.d.a(r104, LarkAppContext.access$getInstance$cp().getContext());
        goto L28
    L20:
        if (r104.length() == 0) goto L23;
        r105 = false;
        goto L24
    L17:
        r104 = null;
    L14:
        r103 = false;
    L74:
        B2(r210, r100);
        return;
    L78:
        return;
    L5:
        r100 = null;
        goto L6
    }

    @Override // com.larksuite.component.universe_design.dialog.UDBaseListDialogAdapter
    public final UDBaseListDialogAdapter.UDDialogListItemViewHolder z2(ViewGroup r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        return new ItemViewHolder(LayoutInflater.from(this.f283818i).inflate(this.f283819j, r100, false));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SelectMenuAdapter(Context r100, int r101, Function1<? super String, String> r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r102, "getImageKey");
        super(r100);
        this.f283818i = r100;
        this.f283819j = r101;
        this.f283820k = r102;
        this.f283821l = new ArrayList();
    }
}
