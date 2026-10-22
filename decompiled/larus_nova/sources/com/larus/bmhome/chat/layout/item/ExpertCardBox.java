package com.larus.bmhome.chat.layout.item;

import android.content.Context;
import android.graphics.Rect;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.producers.DecodeProducer;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonSyntaxException;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.larus.bmhome.chat.ChatParam;
import com.larus.bmhome.chat.layout.widget.AtMostHeightRecyclerView;
import com.larus.bmhome.chat.layout.widget.ScrollToRecyclerView;
import com.larus.bmhome.chat.search.ArticleInfo;
import com.larus.bmhome.chat.search.LruSet;
import com.larus.bmhome.chat.view.FlowTagLayout;
import com.larus.bmhome.databinding.LarusExpertCardBinding;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.message.ItemData;
import com.larus.im.bean.message.ItemShowType;
import com.larus.im.bean.message.ItemType;
import com.larus.im.bean.message.Message;
import com.larus.image.loader.ImageLoaderKt;
import com.larus.nova.R;
import com.larus.utils.CubicBezierInterpolator;
import com.larus.utils.gson.FilterNonNullTypeAdapterFactory;
import com.larus.utils.logger.FLogger;
import com.ss.android.dypay.api.DyPayConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import v19.i5;

/* JADX INFO: loaded from: classes25.dex */
public final class ExpertCardBox extends xc8.h {

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final Map<String, Boolean> f304092t = null;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final Map<String, Integer> f304093u = null;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public b f304094p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public String f304095q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final LarusExpertCardBinding f304096r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final CubicBezierInterpolator f304097s;

    public static final class ExpertTextCardAdapter extends ListAdapter<ItemData, RecyclerView.ViewHolder> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final com.larus.bmhome.chat.api.q0 f304098a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Message f304099b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final BotModel f304100c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f304101d;

        @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\r"}, d2 = {"Lcom/larus/bmhome/chat/layout/item/ExpertCardBox$ExpertTextCardAdapter$ExpertCardMoreViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Lcom/larus/bmhome/chat/layout/item/ExpertCardBox$ExpertTextCardAdapter;Landroid/view/View;)V", "buttonSearchMore", "getButtonSearchMore", "()Landroid/view/View;", "bind", "", MapController.ITEM_LAYER_TAG, "Lcom/larus/bmhome/chat/layout/item/ExpertCardBox$Extra;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public final class ExpertCardMoreViewHolder extends RecyclerView.ViewHolder {

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public static final /* synthetic */ int f304102c = 0;

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final View f304103a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ ExpertTextCardAdapter f304104b;

            public ExpertCardMoreViewHolder(ExpertTextCardAdapter r100, View r101) {
                Intrinsics.checkNotNullParameter(r101, "itemView");
                this.f304104b = r100;
                super(r101);
                this.f304103a = r101.findViewById(R.id.button_search_more);
            }
        }

        @Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J(\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u0018J0\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u001a\u001a\u00020\r2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u00152\u0006\u0010\u001f\u001a\u00020\u0015H\u0002R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006 "}, d2 = {"Lcom/larus/bmhome/chat/layout/item/ExpertCardBox$ExpertTextCardAdapter$ExpertCardTextViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Lcom/larus/bmhome/chat/layout/item/ExpertCardBox$ExpertTextCardAdapter;Landroid/view/View;)V", "textTitle", "Landroid/widget/TextView;", "getTextTitle", "()Landroid/widget/TextView;", "texCreator", "getTexCreator", "imageCreateAvatar", "Lcom/facebook/drawee/view/SimpleDraweeView;", "getImageCreateAvatar", "()Lcom/facebook/drawee/view/SimpleDraweeView;", "bind", "", MapController.ITEM_LAYER_TAG, "Lcom/larus/bmhome/chat/search/ArticleInfo;", "position", "", "rowPosition", "bot", "Lcom/larus/im/bean/bot/BotModel;", "loadImage", "imageView", "url", "", "bizTag", "resizeWidth", "reSizeHeight", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public final class ExpertCardTextViewHolder extends RecyclerView.ViewHolder {

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public static final /* synthetic */ int f304105e = 0;

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final TextView f304106a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final TextView f304107b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final SimpleDraweeView f304108c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final /* synthetic */ ExpertTextCardAdapter f304109d;

            public ExpertCardTextViewHolder(ExpertTextCardAdapter r100, View r101) {
                Intrinsics.checkNotNullParameter(r101, "itemView");
                this.f304109d = r100;
                super(r101);
                this.f304106a = (TextView) r101.findViewById(R.id.text_title);
                this.f304107b = (TextView) r101.findViewById(R.id.text_creator);
                this.f304108c = (SimpleDraweeView) r101.findViewById(R.id.image_creator_avatar);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public final int getItemViewType(int r100) {
            return getItem(r100).getSearchItemType().getType();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public final void onBindViewHolder(RecyclerView.ViewHolder r210, final int r211) {
            Intrinsics.checkNotNullParameter(r210, "holder");
            ItemData r100 = getItem(r211);
            com.larus.bmhome.chat.api.q0.a r110 = null;
            if ((r210 instanceof ExpertCardTextViewHolder) == false) goto L28;
            if ((r100 instanceof ArticleInfo) == false) goto L7;
            final ArticleInfo r101 = (ArticleInfo) r100;
        L8:
            if (r101 != null) goto L10;
            return;
        L10:
            final ExpertCardTextViewHolder r102 = (ExpertCardTextViewHolder) r210;
            final int r103 = this.f304101d;
            final BotModel r104 = this.f304100c;
            r102.getClass();
            Intrinsics.checkNotNullParameter(r104, "bot");
            r102.f304106a.setText(r101.getTitle());
            r102.f304107b.setText(r101.getSiteName());
            String r105 = r101.getIconUrl();
            if (r105 != null) goto L13;
        L16:
            boolean r106 = true;
        L17:
            if (r106 == false) goto L19;
            com.larus.utils.e1.o(r102.f304108c);
        L23:
            View r111 = r102.itemView;
            final ExpertTextCardAdapter r107 = r102.f304109d;
            com.larus.utils.e1.d(r111, new e0(r107, r103, r211, r101, r104, r102));
            Message r112 = this.f304099b;
            com.larus.bmhome.chat.api.q0 r113 = this.f304098a;
            if (r113 == null) goto L26;
            r110 = r113.getProvider();
        L26:
            com.larus.bmhome.chat.layout.holder.helper.b1.a(new com.larus.bmhome.chat.layout.holder.helper.o(r112, r113, r110, null, null, null, null, 120), r210.itemView);
            return;
        L19:
            com.larus.utils.e1.x(r102.f304108c);
            final SimpleDraweeView r108 = r102.f304108c;
            String r109 = r101.getIconUrl();
            if (r109 != null) goto L22;
            r109 = "";
        L22:
            final int r114 = i5.q();
            final int r115 = i5.q();
            ImageLoaderKt.y(r108, r109, "chat.expert_source_icon", new f0(r108, r114, r115), 4);
            goto L23
        L13:
            if (r105.length() == 0) goto L16;
            r106 = false;
            goto L17
        L7:
            r101 = null;
            goto L8
        L28:
            if ((r210 instanceof ExpertCardMoreViewHolder) == true) goto L30;
            return;
        L30:
            if ((r100 instanceof Extra) == false) goto L32;
            final Extra r116 = (Extra) r100;
        L33:
            if (r116 != null) goto L35;
            return;
        L35:
            final ExpertCardMoreViewHolder r117 = (ExpertCardMoreViewHolder) r210;
            r117.getClass();
            Intrinsics.checkNotNullParameter(r116, MapController.ITEM_LAYER_TAG);
            View r118 = r117.f304103a;
            final ExpertTextCardAdapter r119 = r117.f304104b;
            com.larus.utils.e1.d(r118, new d0(r116, r117, r119));
            Message r120 = this.f304099b;
            com.larus.bmhome.chat.api.q0 r121 = this.f304098a;
            if (r121 == null) goto L38;
            r110 = r121.getProvider();
        L38:
            com.larus.bmhome.chat.layout.holder.helper.b1.a(new com.larus.bmhome.chat.layout.holder.helper.o(r120, r121, r110, null, null, null, null, 120), r210.itemView);
            return;
        L32:
            r116 = null;
            goto L33
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
            Intrinsics.checkNotNullParameter(r100, "parent");
            if (r101 != ItemType.TYPE_CARD_IMAGE_TEXT.getType()) goto L5;
            View r102 = LayoutInflater.from(r100.getContext()).inflate(R.layout.larus_item_expert_card_text_holder, r100, false);
            Intrinsics.checkNotNull(r102);
            return new ExpertCardTextViewHolder(this, r102);
        L5:
            View r103 = LayoutInflater.from(r100.getContext()).inflate(R.layout.larus_item_expert_card_more_holder, r100, false);
            Intrinsics.checkNotNull(r103);
            return new ExpertCardMoreViewHolder(this, r103);
        }

        public ExpertTextCardAdapter(com.larus.bmhome.chat.api.q0 r100, Message r101, BotModel r102, int r103) {
            Intrinsics.checkNotNullParameter(r101, "message");
            Intrinsics.checkNotNullParameter(r102, "bot");
            super(new AnonymousClass1());
            this.f304098a = r100;
            this.f304099b = r101;
            this.f304100c = r102;
            this.f304101d = r103;
        }
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0010\u001a\u0004\u0018\u00010\u0003J\n\u0010\u0011\u001a\u0004\u0018\u00010\u0003H\u0016J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J-\u0010\u0019\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dHÖ\u0003J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J\t\u0010 \u001a\u00020\u0003HÖ\u0001R \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR \u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\t\"\u0004\b\r\u0010\u000bR \u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\t\"\u0004\b\u000f\u0010\u000bR\u0014\u0010\u0012\u001a\u00020\u0013X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006!"}, d2 = {"Lcom/larus/bmhome/chat/layout/item/ExpertCardBox$Extra;", "Lcom/larus/im/bean/message/ItemData;", "searchUrl", "", "searchUrlApp", "stepTitleFailed", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getSearchUrl", "()Ljava/lang/String;", "setSearchUrl", "(Ljava/lang/String;)V", "getSearchUrlApp", "setSearchUrlApp", "getStepTitleFailed", "setStepTitleFailed", "getSearchUrlCompat", "getId", "searchItemType", "Lcom/larus/im/bean/message/ItemType;", "getSearchItemType", "()Lcom/larus/im/bean/message/ItemType;", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Extra extends ItemData {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final transient ItemType f304110a;

        @SerializedName("search_url")
        private String searchUrl;

        @SerializedName("search_url_app")
        private String searchUrlApp;

        @SerializedName("title_failed")
        private String stepTitleFailed;

        public Extra() {
            this(null, null, null, 7, null);
        }

        public static /* synthetic */ Extra copy$default(Extra r100, String r101, String r102, String r103, int r104, Object r105) {
            if ((r104 & 1) == 0) goto L6;
            r101 = r100.searchUrl;
        L6:
            if ((r104 & 2) == 0) goto L9;
            r102 = r100.searchUrlApp;
        L9:
            if ((r104 & 4) == 0) goto L12;
            r103 = r100.stepTitleFailed;
        L12:
            return r100.copy(r101, r102, r103);
        }

        public final String component1() {
            return this.searchUrl;
        }

        public final String component2() {
            return this.searchUrlApp;
        }

        public final String component3() {
            return this.stepTitleFailed;
        }

        public final Extra copy(String r100, String r101, String r102) {
            return new Extra(r100, r101, r102);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof Extra) == true) goto L8;
            return false;
        L8:
            Extra r101 = (Extra) r100;
            if (Intrinsics.areEqual(this.searchUrl, r101.searchUrl) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.searchUrlApp, r101.searchUrlApp) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.stepTitleFailed, r101.stepTitleFailed) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public int hashCode() {
            String r100 = this.searchUrl;
            int r101 = 0;
            if (r100 != null) goto L5;
            int r102 = 0;
        L6:
            int r103 = r102 * 31;
            String r104 = this.searchUrlApp;
            if (r104 != null) goto L9;
            int r105 = 0;
        L10:
            int r106 = (r103 + r105) * 31;
            String r107 = this.stepTitleFailed;
            if (r107 == null) goto L15;
            r101 = r107.hashCode();
        L15:
            return r106 + r101;
        L9:
            r105 = r104.hashCode();
            goto L10
        L5:
            r102 = r100.hashCode();
            goto L6
        }

        public String toString() {
            return "Extra(searchUrl=" + this.searchUrl + ", searchUrlApp=" + this.searchUrlApp + ", stepTitleFailed=" + this.stepTitleFailed + ')';
        }

        public final String getSearchUrlCompat() {
            String r100 = this.searchUrlApp;
            if (r100 != null) goto L5;
        L8:
            boolean r101 = true;
        L9:
            if (r101 == false) goto L12;
            return this.searchUrl;
        L12:
            return this.searchUrlApp;
        L5:
            if (r100.length() == 0) goto L8;
            r101 = false;
            goto L9
        }

        @Override // com.larus.im.bean.message.ItemData
        public String getId() {
            return this.searchUrl;
        }

        @Override // com.larus.im.bean.message.ItemData
        public ItemType getSearchItemType() {
            return this.f304110a;
        }

        public final String getSearchUrl() {
            return this.searchUrl;
        }

        public final String getSearchUrlApp() {
            return this.searchUrlApp;
        }

        public final String getStepTitleFailed() {
            return this.stepTitleFailed;
        }

        public final void setSearchUrl(String r100) {
            this.searchUrl = r100;
        }

        public final void setSearchUrlApp(String r100) {
            this.searchUrlApp = r100;
        }

        public final void setStepTitleFailed(String r100) {
            this.stepTitleFailed = r100;
        }

        public Extra(String r100, String r101, String r102) {
            this.searchUrl = r100;
            this.searchUrlApp = r101;
            this.stepTitleFailed = r102;
            this.f304110a = ItemType.TYPE_CARD_MORE;
        }

        public /* synthetic */ Extra(String r100, String r101, String r102, int r103, DefaultConstructorMarker r104) {
            if ((r103 & 1) == 0) goto L6;
            r100 = null;
        L6:
            if ((r103 & 2) == 0) goto L9;
            r101 = null;
        L9:
            if ((r103 & 4) == 0) goto L11;
            r102 = null;
        L11:
            this(r100, r101, r102);
        }
    }

    public static final class StepAdapter extends ListAdapter<c, RecyclerView.ViewHolder> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final com.larus.bmhome.chat.api.q0 f304111a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Message f304112b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final BotModel f304113c;

        @Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J&\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020\u001aJ\u0018\u00101\u001a\u00020\u00072\u0006\u00102\u001a\u0002032\u0006\u00104\u001a\u00020 H\u0002J0\u00105\u001a\u00020)2\u0006\u00106\u001a\u00020\u000b2\u0006\u00107\u001a\u00020 2\u0006\u00108\u001a\u00020 2\u0006\u00109\u001a\u00020\u001a2\u0006\u0010:\u001a\u00020\u001aH\u0002J\u000e\u0010;\u001a\u00020)2\u0006\u0010<\u001a\u00020=J\u0010\u0010>\u001a\u00020)2\u0006\u0010?\u001a\u00020 H\u0002J\u0014\u0010@\u001a\u000e\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020\u001a0AH\u0002J\u0010\u0010B\u001a\u00020)2\u0006\u0010C\u001a\u00020\u001aH\u0002J \u0010D\u001a\u00020)2\u0006\u0010E\u001a\u00020\u001a2\u0006\u00100\u001a\u00020\u001a2\u0006\u0010F\u001a\u00020GH\u0002R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u000e\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0015\u001a\u00020\u0016¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0019\u001a\u00020\u001aX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001c\u0010\u001f\u001a\u0004\u0018\u00010 X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001c\u0010%\u001a\u0004\u0018\u00010 X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\"\"\u0004\b'\u0010$¨\u0006H"}, d2 = {"Lcom/larus/bmhome/chat/layout/item/ExpertCardBox$StepAdapter$ExpertCardNormalViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Lcom/larus/bmhome/chat/layout/item/ExpertCardBox$StepAdapter;Landroid/view/View;)V", "textStepTitle", "Landroid/widget/TextView;", "getTextStepTitle", "()Landroid/widget/TextView;", "imageStepIcon", "Lcom/facebook/drawee/view/SimpleDraweeView;", "getImageStepIcon", "()Lcom/facebook/drawee/view/SimpleDraweeView;", "progressStepLoading", "getProgressStepLoading", "()Landroid/view/View;", "tagLayoutContent", "Lcom/larus/bmhome/chat/view/FlowTagLayout;", "getTagLayoutContent", "()Lcom/larus/bmhome/chat/view/FlowTagLayout;", "recyclerView", "Lcom/larus/bmhome/chat/layout/widget/ScrollToRecyclerView;", "getRecyclerView", "()Lcom/larus/bmhome/chat/layout/widget/ScrollToRecyclerView;", "currentRowPosition", "", "getCurrentRowPosition", "()I", "setCurrentRowPosition", "(I)V", "currentStepId", "", "getCurrentStepId", "()Ljava/lang/String;", "setCurrentStepId", "(Ljava/lang/String;)V", "currentMsgId", "getCurrentMsgId", "setCurrentMsgId", "bind", "", MapController.ITEM_LAYER_TAG, "Lcom/larus/bmhome/chat/layout/item/ExpertCardBox$ExpertStep;", "message", "Lcom/larus/im/bean/message/Message;", "bot", "Lcom/larus/im/bean/bot/BotModel;", "rowPosition", "generateVerticalTextView", "parent", "Landroid/view/ViewGroup;", "text", "loadImage", "imageView", "url", "bizTag", "resizeWidth", "reSizeHeight", "setFullVisibleStatus", "fullVisible", "", "setupCardScrollShowReporter", "id", "getExpertScrollOffsetRecorder", "", "handleExposeEndView", "lastExposePosition", "itemFirstShowAction", "position", "itemData", "Lcom/larus/im/bean/message/ItemData;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public final class ExpertCardNormalViewHolder extends RecyclerView.ViewHolder {

            /* JADX INFO: renamed from: j, reason: collision with root package name */
            public static final /* synthetic */ int f304114j = 0;

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final TextView f304115a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final SimpleDraweeView f304116b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final View f304117c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final FlowTagLayout f304118d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public final ScrollToRecyclerView f304119e;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            public int f304120f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            public String f304121g;

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            public String f304122h;

            /* JADX INFO: renamed from: i, reason: collision with root package name */
            public final /* synthetic */ StepAdapter f304123i;

            public final void V3(boolean r110) {
                if (r110 == true) goto L5;
                this.f304119e.clearOnScrollListeners();
                this.f304119e.setRecyclerScrollListener(new g0(this));
                return;
            L5:
                RecyclerView.LayoutManager r111 = this.f304119e.getLayoutManager();
                if ((r111 instanceof LinearLayoutManager) == false) goto L8;
                LinearLayoutManager r112 = (LinearLayoutManager) r111;
            L9:
                if (r112 != null) goto L11;
                return;
            L11:
                RecyclerView.Adapter r100 = this.f304119e.getAdapter();
                if ((r100 instanceof ListAdapter) == false) goto L14;
                ListAdapter r101 = (ListAdapter) r100;
            L15:
                if (r101 != null) goto L17;
                return;
            L17:
                Iterator r102 = r101.getCurrentList().iterator();
            L19:
                if (r102.hasNext() == false) goto L26;
                Object r103 = r102.next();
                if ((r103 instanceof ItemData) == false) goto L23;
                ItemData r104 = (ItemData) r103;
            L24:
                if (r104 == null) goto L19;
                r104.setItemShowType(ItemShowType.ITEM_SHOW_TYPE_NONE);
                goto L19
            L23:
                r104 = null;
                goto L24
            L26:
                int r105 = r112.findFirstVisibleItemPosition();
                int r106 = r112.findLastVisibleItemPosition();
                if (r105 > r106) goto L46;
            L28:
                Object r107 = CollectionsKt.getOrNull(r101.getCurrentList(), r105);
                if ((r107 instanceof ItemData) == false) goto L31;
                ItemData r108 = (ItemData) r107;
            L32:
                if (r108 == null) goto L33;
                View r109 = r112.findViewByPosition(r105);
                if (r109 == null) goto L36;
                Rect r113 = new Rect();
                boolean r114 = r109.getGlobalVisibleRect(r113);
                float r115 = r113.width() / RangesKt.coerceAtLeast(r109.getWidth(), 0.1f);
                if (r114 == true) goto L40;
            L44:
                if (r105 == r106) goto L46;
                r105 = r105 + 1;
                goto L28
            L40:
                if (r115 < 0.5f) goto L44;
                if (r108.getItemShowType() != ItemShowType.ITEM_SHOW_TYPE_NONE) goto L44;
                r108.setItemShowType(ItemShowType.ITEM_SHOW_TYPE_AUTO);
                U3(r105, this.f304120f, r108);
                goto L44
            L36:
                return;
            L33:
                return;
            L31:
                r108 = null;
            L46:
                final String r116 = this.f304122h + this.f304121g;
                this.f304119e.clearOnScrollListeners();
                this.f304119e.setRecyclerScrollListener(new j0(this, r116));
                this.f304119e.addOnScrollListener(new ExpertCardBox$StepAdapter$ExpertCardNormalViewHolder$setupCardScrollShowReporter$2(this));
                return;
            L14:
                r101 = null;
                goto L15
            L8:
                r112 = null;
                goto L9
            }

            public ExpertCardNormalViewHolder(StepAdapter r100, View r101) {
                Intrinsics.checkNotNullParameter(r101, "itemView");
                this.f304123i = r100;
                super(r101);
                this.f304115a = (TextView) r101.findViewById(R.id.text_step_title);
                this.f304116b = (SimpleDraweeView) r101.findViewById(R.id.image_step_icon);
                this.f304117c = r101.findViewById(R.id.progress_step_loading);
                this.f304118d = (FlowTagLayout) r101.findViewById(R.id.tag_layout_step_content);
                this.f304119e = (ScrollToRecyclerView) r101.findViewById(R.id.rv_step_horizontal_content);
                this.f304120f = -1;
            }

            public static final void T3(ExpertCardNormalViewHolder r100, int r101) {
                RecyclerView.Adapter r102 = r100.f304119e.getAdapter();
                ItemData r103 = null;
                if ((r102 instanceof ListAdapter) == false) goto L5;
                ListAdapter r104 = (ListAdapter) r102;
            L6:
                if (r104 == null) goto L18;
                Object r105 = CollectionsKt.getOrNull(r104.getCurrentList(), r101);
                if ((r105 instanceof ItemData) == false) goto L11;
                r103 = (ItemData) r105;
            L11:
                if (r103 == null) goto L19;
                ItemShowType r106 = r103.getItemShowType();
                ItemShowType r107 = ItemShowType.ITEM_SHOW_TYPE_NONE;
                if (r106 == r107) goto L20;
                r103.setItemShowType(r107);
                return;
            L20:
                return;
            L19:
                return;
            L18:
                return;
            L5:
                r104 = null;
                goto L6
            }

            public final void U3(int r110, int r210, ItemData r211) {
                int r100 = oi8.f.f523448a;
                com.larus.bmhome.chat.api.q0 r101 = this.f304123i.f304111a;
                ChatParam r102 = null;
                if (r101 == null) goto L5;
                LruSet<String> r103 = r101.E7();
            L6:
                StepAdapter r104 = this.f304123i;
                Message r105 = r104.f304112b;
                com.larus.bmhome.chat.api.q0 r106 = r104.f304111a;
                if (r106 == null) goto L9;
                r102 = r106.getChatParam();
            L9:
                ChatParam r107 = r102;
                String r108 = this.f304123i.f304113c.getBotId();
                if (r108 != null) goto L12;
                r108 = "";
            L12:
                oi8.f.k(r103, r105, r107, r210, r110, r211, null, "link", r108, "half", "expert", 0, 0, null, 14400);
                return;
            L5:
                r103 = null;
                goto L6
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public final int getItemViewType(int r100) {
            return getItem(r100).b();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public final void onBindViewHolder(RecyclerView.ViewHolder r210, int r211) {
            Intrinsics.checkNotNullParameter(r210, "holder");
            c r100 = getItem(r211);
            if ((r210 instanceof ExpertCardNormalViewHolder) == false) goto L79;
            List<c> r101 = getCurrentList();
            ArrayList r102 = new ArrayList();
            Iterator<T> r103 = r101.iterator();
        L6:
            if (r103.hasNext() == false) goto L10;
            String r104 = ((c) r103.next()).e();
            if (r104 == null) goto L6;
            r102.add(r104);
            goto L6
        L10:
            int r105 = CollectionsKt.indexOf(r102, r100.e());
            final ExpertCardNormalViewHolder r106 = (ExpertCardNormalViewHolder) r210;
            Intrinsics.checkNotNull(r100);
            Message r107 = this.f304112b;
            BotModel r108 = this.f304113c;
            r106.getClass();
            Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
            Intrinsics.checkNotNullParameter(r107, "message");
            Intrinsics.checkNotNullParameter(r108, "bot");
            r106.f304122h = r107.getMessageId();
            r106.f304121g = r100.e();
            r106.f304120f = r105;
            TextView r109 = r106.f304115a;
            if (r100.f304128b == false) goto L16;
            Extra r110 = r100.a();
            if (r110 == null) goto L16;
            String r111 = r110.getStepTitleFailed();
            if (r111 == null) goto L16;
        L17:
            r109.setText(r111);
            if (r100.f304128b == false) goto L21;
            com.larus.utils.e1.o(r106.f304117c);
            com.larus.utils.e1.x(r106.f304116b);
            r106.f304116b.setImageResource(R.drawable.larus_icon_expert_fail);
        L36:
            com.larus.bmhome.chat.api.q0.a r112 = null;
            if (r100.i() == false) goto L47;
            com.larus.utils.e1.o(r106.f304119e);
            List<e> r113 = r100.h();
            ArrayList r114 = new ArrayList();
            Iterator r115 = ((ArrayList) r113).iterator();
        L40:
            if (r115.hasNext() == false) goto L45;
            String r116 = ((e) r115.next()).a();
            if (r116 != null) goto L44;
            r116 = "";
        L44:
            r114.add(new FlowTagLayout.a(r116, 0, null));
            goto L40
        L45:
            final FlowTagLayout r117 = r106.f304118d;
            com.larus.utils.e1.x(r117);
            r117.setTagViewProvide(new h0(r106, r117));
            r117.a(r114, false);
        L61:
            Message r118 = this.f304112b;
            com.larus.bmhome.chat.api.q0 r119 = this.f304111a;
            if (r119 == null) goto L64;
            r112 = r119.getProvider();
        L64:
            com.larus.bmhome.chat.layout.holder.helper.b1.a(new com.larus.bmhome.chat.layout.holder.helper.o(r118, r119, r112, new com.larus.bmhome.chat.layout.holder.helper.x2(), null, null, null, 112), r210.itemView);
            return;
        L47:
            if (r100.j() == false) goto L60;
            com.larus.utils.e1.o(r106.f304118d);
            com.larus.utils.e1.x(r106.f304119e);
            ExpertTextCardAdapter r120 = new ExpertTextCardAdapter(r106.f304123i.f304111a, r107, r108, r105);
            ScrollToRecyclerView r121 = r106.f304119e;
            r121.setLayoutManager(new LinearLayoutManager(r121.getContext(), 0, false));
            r121.setAdapter(r120);
            ArrayList r122 = new ArrayList();
            List<d> r123 = r100.g();
            ArrayList r124 = new ArrayList();
            Iterator r125 = ((ArrayList) r123).iterator();
        L50:
            if (r125.hasNext() == false) goto L54;
            ArticleInfo r126 = ((d) r125.next()).a();
            if (r126 == null) goto L50;
            r124.add(r126);
            goto L50
        L54:
            r122.addAll(r124);
            Extra r127 = r100.a();
            if (r127 != null) goto L57;
        L59:
            r120.submitList(r122);
            r106.f304119e.post(new i0(r106));
            goto L61
        L57:
            if (com.larus.utils.o0.d(r127.getSearchUrlCompat()) == false) goto L59;
            r122.add(r127);
            goto L59
        L60:
            com.larus.utils.e1.o(r106.f304118d);
            com.larus.utils.e1.o(r106.f304119e);
            goto L61
        L21:
            if (r100.f304127a == false) goto L23;
            com.larus.utils.e1.x(r106.f304117c);
            com.larus.utils.e1.o(r106.f304116b);
            goto L36
        L23:
            com.larus.utils.e1.o(r106.f304117c);
            com.larus.utils.e1.x(r106.f304116b);
            String r128 = r100.d();
            if (r128 != null) goto L26;
        L29:
            boolean r129 = true;
        L30:
            if (r129 == false) goto L32;
            r106.f304116b.setImageResource(r100.c());
            goto L36
        L32:
            final SimpleDraweeView r130 = r106.f304116b;
            String r131 = r100.d();
            if (r131 != null) goto L35;
            r131 = "";
        L35:
            final int r132 = i5.A();
            final int r133 = i5.A();
            ImageLoaderKt.y(r130, r131, "chat.expert_step_icon", new k0(r130, r132, r133), 4);
            goto L36
        L26:
            if (r128.length() == 0) goto L29;
            r129 = false;
        L16:
            r111 = r100.f();
            goto L17
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
            Intrinsics.checkNotNullParameter(r100, "parent");
            View r102 = LayoutInflater.from(r100.getContext()).inflate(R.layout.larus_item_expert_card_step_normal_holder, r100, false);
            Intrinsics.checkNotNull(r102);
            ExpertCardNormalViewHolder r103 = new ExpertCardNormalViewHolder(this, r102);
            r102.setTag(r103);
            return r103;
        }

        public StepAdapter(com.larus.bmhome.chat.api.q0 r100, Message r101, BotModel r102) {
            Intrinsics.checkNotNullParameter(r101, "message");
            Intrinsics.checkNotNullParameter(r102, "bot");
            super(new AnonymousClass1());
            this.f304111a = r100;
            this.f304112b = r101;
            this.f304113c = r102;
        }
    }

    public static final class a {
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0019\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0011\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u001b\u0010\u0010\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u000b2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R&\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\u0006R\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0018"}, d2 = {"Lcom/larus/bmhome/chat/layout/item/ExpertCardBox$ExpertCardData;", "", "expertStep", "", "Lcom/larus/bmhome/chat/layout/item/ExpertCardBox$ExpertStep;", "<init>", "(Ljava/util/List;)V", "getExpertStep", "()Ljava/util/List;", "setExpertStep", "isFold", "", "()Z", "setFold", "(Z)V", "component1", "copy", "equals", "other", "hashCode", "", "toString", "", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class b {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int f304125b = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public transient boolean f304126a;

        @SerializedName("copilot")
        @JsonAdapter(FilterNonNullTypeAdapterFactory.class)
        private List<c> expertStep;

        public static final class a {
            public static b a(String r100) {
                if (r100 != null) goto L4;
            L7:
                boolean r101 = true;
            L9:
                if (r101 == false) goto L16;
                return null;
            L16:
                return (b) new Gson().fromJson(r100, b.class);
            L13:
                e = move-exception;
                FLogger.f375446a.e("ExpertCardBox", "convertDataBean:" + g2a.d.d(r100), e);
                return null;
            L4:
                if (r100.length() == 0) goto L7;
                r101 = false;
                goto L9
            }
        }

        static {
        }

        public b() {
            this(null);
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.expertStep, ((b) r100).expertStep) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            List<c> r100 = this.expertStep;
            if (r100 != null) goto L6;
            return 0;
        L6:
            return r100.hashCode();
        }

        public final String toString() {
            return "ExpertCardData(expertStep=" + this.expertStep + ')';
        }

        public final List<c> a() {
            return this.expertStep;
        }

        public b(Object r100) {
            this.expertStep = null;
        }
    }

    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\b\u0086\b\u0018\u0000 =2\u00020\u0001:\u0001=Bk\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005\u0012\u0012\b\u0002\u0010\t\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0018\u00010\n\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\u0010\u0010\u0011J\u0006\u0010'\u001a\u00020\u000fJ\u0006\u0010(\u001a\u00020\u000fJ\u0006\u0010\u0017\u001a\u00020\u0005J\u000b\u0010/\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u00100\u001a\u00020\u0005HÆ\u0003J\u000b\u00101\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00102\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u00103\u001a\u00020\u0005HÆ\u0003J\u0013\u00104\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0018\u00010\nHÆ\u0003J\u000b\u00105\u001a\u0004\u0018\u00010\rHÆ\u0003J\u0010\u00106\u001a\u0004\u0018\u00010\u000fHÆ\u0003¢\u0006\u0002\u0010\u001dJr\u00107\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\b\u001a\u00020\u00052\u0012\b\u0002\u0010\t\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0018\u00010\n2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÆ\u0001¢\u0006\u0002\u00108J\u0013\u00109\u001a\u00020\u000f2\b\u0010:\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010;\u001a\u00020\u0005HÖ\u0001J\t\u0010<\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0013R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0013R\u0016\u0010\b\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0015R \u0010\t\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0018\u0010\f\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u001a\u0010\u000e\u001a\u0004\u0018\u00010\u000f8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001e\u001a\u0004\b\u000e\u0010\u001dR\u001a\u0010\u001f\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001a\u0010$\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010!\"\u0004\b&\u0010#R\u0017\u0010)\u001a\b\u0012\u0004\u0012\u00020*0\n8F¢\u0006\u0006\u001a\u0004\b+\u0010\u001aR\u0017\u0010,\u001a\b\u0012\u0004\u0012\u00020-0\n8F¢\u0006\u0006\u001a\u0004\b.\u0010\u001a¨\u0006>"}, d2 = {"Lcom/larus/bmhome/chat/layout/item/ExpertCardBox$ExpertStep;", "", "stepId", "", "stepType", "", "stepTitle", "stepIcon", "stepContentType", "stepContents", "", "Lcom/google/gson/JsonElement;", "ext", "Lcom/larus/bmhome/chat/layout/item/ExpertCardBox$Extra;", DecodeProducer.EXTRA_IS_FINAL, "", "<init>", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;ILjava/util/List;Lcom/larus/bmhome/chat/layout/item/ExpertCardBox$Extra;Ljava/lang/Boolean;)V", "getStepId", "()Ljava/lang/String;", "getStepType", "()I", "getStepTitle", "getStepIcon", "getStepContentType", "getStepContents", "()Ljava/util/List;", "getExt", "()Lcom/larus/bmhome/chat/layout/item/ExpertCardBox$Extra;", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", DyPayConstant.KEY_SHOW_LOADING, "getShowLoading", "()Z", "setShowLoading", "(Z)V", "showFail", "getShowFail", "setShowFail", "isContentTypeText", "isContentTypeTextCard", "textList", "Lcom/larus/bmhome/chat/layout/item/ExpertCardBox$StepTextContent;", "getTextList", "textCardList", "Lcom/larus/bmhome/chat/layout/item/ExpertCardBox$StepTextCardContent;", "getTextCardList", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;ILjava/util/List;Lcom/larus/bmhome/chat/layout/item/ExpertCardBox$Extra;Ljava/lang/Boolean;)Lcom/larus/bmhome/chat/layout/item/ExpertCardBox$ExpertStep;", "equals", "other", "hashCode", "toString", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public transient boolean f304127a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public transient boolean f304128b;

        @SerializedName("ext")
        private final Extra ext;

        @SerializedName("is_final")
        private final Boolean isFinal;

        @SerializedName("step_content_type")
        private final int stepContentType;

        @SerializedName("step_contents")
        private final List<JsonElement> stepContents;

        @SerializedName("step_icon")
        private final String stepIcon;

        @SerializedName("step_id")
        private final String stepId;

        @SerializedName("step_title")
        private final String stepTitle;

        @SerializedName("step_type")
        private final int stepType;

        public static final class a {
        }

        static {
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof c) == true) goto L8;
            return false;
        L8:
            c r101 = (c) r100;
            if (Intrinsics.areEqual(this.stepId, r101.stepId) == true) goto L12;
            return false;
        L12:
            if (this.stepType == r101.stepType) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.stepTitle, r101.stepTitle) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.stepIcon, r101.stepIcon) == true) goto L21;
            return false;
        L21:
            if (this.stepContentType == r101.stepContentType) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.stepContents, r101.stepContents) == true) goto L27;
            return false;
        L27:
            if (Intrinsics.areEqual(this.ext, r101.ext) == true) goto L30;
            return false;
        L30:
            if (Intrinsics.areEqual(this.isFinal, r101.isFinal) == true) goto L32;
            return false;
        L32:
            return true;
        }

        public final int hashCode() {
            String r100 = this.stepId;
            int r101 = 0;
            if (r100 != null) goto L5;
            int r102 = 0;
        L6:
            int r103 = ((r102 * 31) + this.stepType) * 31;
            String r104 = this.stepTitle;
            if (r104 != null) goto L9;
            int r105 = 0;
        L10:
            int r106 = (r103 + r105) * 31;
            String r107 = this.stepIcon;
            if (r107 != null) goto L13;
            int r108 = 0;
        L14:
            int r109 = (((r106 + r108) * 31) + this.stepContentType) * 31;
            List<JsonElement> r110 = this.stepContents;
            if (r110 != null) goto L17;
            int r111 = 0;
        L18:
            int r112 = (r109 + r111) * 31;
            Extra r113 = this.ext;
            if (r113 != null) goto L21;
            int r114 = 0;
        L22:
            int r115 = (r112 + r114) * 31;
            Boolean r116 = this.isFinal;
            if (r116 == null) goto L27;
            r101 = r116.hashCode();
        L27:
            return r115 + r101;
        L21:
            r114 = r113.hashCode();
            goto L22
        L17:
            r111 = r110.hashCode();
            goto L18
        L13:
            r108 = r107.hashCode();
            goto L14
        L9:
            r105 = r104.hashCode();
            goto L10
        L5:
            r102 = r100.hashCode();
            goto L6
        }

        public final String toString() {
            return "ExpertStep(stepId=" + this.stepId + ", stepType=" + this.stepType + ", stepTitle=" + this.stepTitle + ", stepIcon=" + this.stepIcon + ", stepContentType=" + this.stepContentType + ", stepContents=" + this.stepContents + ", ext=" + this.ext + ", isFinal=" + this.isFinal + ')';
        }

        public final int c() {
            int r100 = this.stepType;
            if (r100 != 1) goto L5;
            return R.drawable.larus_icon_expert_question;
        L5:
            if (r100 != 2) goto L7;
            return R.drawable.larus_icon_expert_searching_web;
        L7:
            if (r100 != 3) goto L9;
            return R.drawable.larus_icon_expert_considering;
        L9:
            if (r100 == 4) goto L11;
            return R.drawable.larus_icon_expert_fail;
        L11:
            return R.drawable.larus_icon_expert_done;
        }

        public final List<d> g() {
            ArrayList r100 = new ArrayList();
            if (j() == false) goto L17;
            List<JsonElement> r101 = this.stepContents;
            if (r101 == null) goto L17;
            List r102 = CollectionsKt.filterNotNull(r101);
            if (r102 == null) goto L17;
            Iterator r103 = r102.iterator();
        L10:
            if (r103.hasNext() == false) goto L17;
            JsonElement r104 = (JsonElement) r103.next();
            d r105 = (d) GsonProtectorUtils.fromJson(new Gson(), r104, d.class);     // Catch: JsonSyntaxException -> L14
        L15:
            if (r105 == null) goto L10;
            r100.add(r105);
        L14:
            r105 = null;
        L17:
            return r100;
        }

        public final List<e> h() {
            ArrayList r100 = new ArrayList();
            if (i() == false) goto L17;
            List<JsonElement> r101 = this.stepContents;
            if (r101 == null) goto L17;
            List r102 = CollectionsKt.filterNotNull(r101);
            if (r102 == null) goto L17;
            Iterator r103 = r102.iterator();
        L10:
            if (r103.hasNext() == false) goto L17;
            JsonElement r104 = (JsonElement) r103.next();
            e r105 = (e) GsonProtectorUtils.fromJson(new Gson(), r104, e.class);     // Catch: JsonSyntaxException -> L14
        L15:
            if (r105 == null) goto L10;
            r100.add(r105);
        L14:
            r105 = null;
        L17:
            return r100;
        }

        public final boolean i() {
            if (this.stepContentType == 1) goto L7;
            return false;
        L7:
            return true;
        }

        public final boolean j() {
            if (this.stepContentType != 2) goto L5;
            return true;
        L5:
            return false;
        }

        public c() {
            this.stepId = null;
            this.stepType = 0;
            this.stepTitle = null;
            this.stepIcon = null;
            this.stepContentType = 0;
            this.stepContents = null;
            this.ext = null;
            this.isFinal = null;
        }

        public final Extra a() {
            return this.ext;
        }

        public final int b() {
            return this.stepContentType;
        }

        public final String d() {
            return this.stepIcon;
        }

        public final String e() {
            return this.stepId;
        }

        public final String f() {
            return this.stepTitle;
        }

        public final Boolean k() {
            return this.isFinal;
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/larus/bmhome/chat/layout/item/ExpertCardBox$StepTextCardContent;", "", "textCard", "Lcom/larus/bmhome/chat/search/ArticleInfo;", "<init>", "(Lcom/larus/bmhome/chat/search/ArticleInfo;)V", "getTextCard", "()Lcom/larus/bmhome/chat/search/ArticleInfo;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class d {

        @SerializedName("text_card")
        private final ArticleInfo textCard;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof d) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.textCard, ((d) r100).textCard) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            ArticleInfo r100 = this.textCard;
            if (r100 != null) goto L6;
            return 0;
        L6:
            return r100.hashCode();
        }

        public final String toString() {
            return "StepTextCardContent(textCard=" + this.textCard + ')';
        }

        public d() {
            this.textCard = null;
        }

        public final ArticleInfo a() {
            return this.textCard;
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0010"}, d2 = {"Lcom/larus/bmhome/chat/layout/item/ExpertCardBox$StepTextContent;", "", "text", "", "<init>", "(Ljava/lang/String;)V", "getText", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class e {

        @SerializedName("text")
        private final String text;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof e) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.text, ((e) r100).text) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            String r100 = this.text;
            if (r100 != null) goto L6;
            return 0;
        L6:
            return r100.hashCode();
        }

        public final String toString() {
            return "StepTextContent(text=" + this.text + ')';
        }

        public e() {
            this.text = null;
        }

        public final String a() {
            return this.text;
        }
    }

    static {
        f304092t = new LinkedHashMap();
        f304093u = new LinkedHashMap();
    }

    private final Map<String, Boolean> getExpertCardFoldRecorder() {
        return f304092t;
    }

    public ExpertCardBox(Context r110) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r110);
        View r111 = LayoutInflater.from(r110).inflate(R.layout.larus_expert_card, this, false);
        addView(r111);
        int r100 = R.id.button_expert_fold_arrow;
        AppCompatImageView r101 = (AppCompatImageView) ViewBindings.findChildViewById(r111, R.id.button_expert_fold_arrow);
        if (r101 == null) goto L17;
        r100 = R.id.expert_card_title;
        if (((TextView) ViewBindings.findChildViewById(r111, R.id.expert_card_title)) == null) goto L17;
        r100 = R.id.layout_expert_title_fold;
        LinearLayout r102 = (LinearLayout) ViewBindings.findChildViewById(r111, R.id.layout_expert_title_fold);
        if (r102 == null) goto L17;
        r100 = R.id.step_container;
        FrameLayout r103 = (FrameLayout) ViewBindings.findChildViewById(r111, R.id.step_container);
        if (r103 == null) goto L17;
        r100 = R.id.step_recyclerview;
        AtMostHeightRecyclerView r104 = (AtMostHeightRecyclerView) ViewBindings.findChildViewById(r111, R.id.step_recyclerview);
        if (r104 == null) goto L17;
        r100 = R.id.text_expert_title_completed;
        TextView r105 = (TextView) ViewBindings.findChildViewById(r111, R.id.text_expert_title_completed);
        if (r105 == null) goto L17;
        this.f304096r = new LarusExpertCardBinding((LinearLayout) r111, r101, r102, r103, r104, r105);
        this.f304097s = new CubicBezierInterpolator(0.0f, 0.0f, 0.58f);
        return;
    L17:
        throw new NullPointerException("Missing required view with ID: ".concat(r111.getResources().getResourceName(r100)));
    }

    public static final /* synthetic */ Map n(ExpertCardBox r100) {
        return r100.getExpertCardFoldRecorder();
    }

    public final void o(boolean r100) {
        if (r100 == false) goto L4;
        this.f304096r.f310878b.setRotation(0.0f);
        com.larus.utils.e1.x(this.f304096r.f310882f);
        return;
    L4:
        this.f304096r.f310878b.setRotation(180.0f);
        com.larus.utils.e1.q(this.f304096r.f310882f);
    }

    public final void setFullVisibleStatus(boolean r100) {
        RecyclerView.LayoutManager r101 = this.f304096r.f310881e.getLayoutManager();
        ListAdapter r102 = null;
        if ((r101 instanceof LinearLayoutManager) == false) goto L5;
        LinearLayoutManager r103 = (LinearLayoutManager) r101;
    L6:
        if (r103 != null) goto L8;
        return;
    L8:
        RecyclerView.Adapter r104 = this.f304096r.f310881e.getAdapter();
        if ((r104 instanceof ListAdapter) == false) goto L11;
        r102 = (ListAdapter) r104;
    L11:
        if (r102 != null) goto L13;
        return;
    L13:
        int r105 = r103.findFirstVisibleItemPosition();
        int r106 = r103.findLastVisibleItemPosition();
        if (r105 > r106) goto L23;
    L15:
        View r107 = r103.findViewByPosition(r105);
        if (r107 == null) goto L17;
        Object r108 = r107.getTag();
        if ((r108 instanceof StepAdapter.ExpertCardNormalViewHolder) == false) goto L21;
        ((StepAdapter.ExpertCardNormalViewHolder) r108).V3(r100);
    L21:
        if (r105 == r106) goto L26;
        r105 = r105 + 1;
        goto L15
    L26:
        return;
    L17:
        return;
    L23:
        return;
    L5:
        r103 = null;
        goto L6
    }
}
