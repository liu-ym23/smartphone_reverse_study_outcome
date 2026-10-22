package com.larus.bmhome.view.resourcebar;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.platform.comapi.map.MapController;
import com.larus.bmhome.view.resourcebar.bean.Mode;
import com.larus.bmhome.view.resourcebar.bean.ResourceBarConfig;
import com.larus.bmhome.view.resourcebar.bean.ResourceItemBean;
import com.larus.bmhome.view.resourcebar.bean.ResourceType;
import com.larus.bmhome.view.resourcebar.viewholder.AddResourceViewHolder;
import com.larus.bmhome.view.resourcebar.viewholder.AudioResourceViewHolder;
import com.larus.bmhome.view.resourcebar.viewholder.BaseResourceViewHolder;
import com.larus.bmhome.view.resourcebar.viewholder.FileResourceViewHolder;
import com.larus.bmhome.view.resourcebar.viewholder.ImgResourceViewHolder;
import com.larus.bmhome.view.resourcebar.viewholder.PayloadResourceViewHolder;
import com.larus.bmhome.view.resourcebar.viewholder.VideoResourceViewHolder;
import com.larus.chat.common.databinding.LarusAddResourceItemViewBinding;
import com.larus.chat.common.databinding.LarusFileResourceItemViewBinding;
import com.larus.im.bean.message.Image;
import com.larus.im.bean.message.ImageObj;
import com.larus.nova.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import nda.d;
import v19.i5;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000q\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0014\u0018\u0000 D2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001DB\u001b\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J&\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u001a2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020!0 H\u0016J\u0018\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u001aH\u0016J\u0014\u0010\"\u001a\u00020\u001c*\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u001aH\u0002J\u000e\u0010#\u001a\u00020\u001c2\u0006\u0010\u0003\u001a\u00020\u0004J\"\u0010$\u001a\u00020\u001c2\u001a\u0010%\u001a\u0016\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010j\n\u0012\u0004\u0012\u00020\u0011\u0018\u0001`\u0012J\b\u0010&\u001a\u00020\u001cH\u0007J\u0010\u0010'\u001a\u00020\u001c2\u0006\u0010(\u001a\u00020\u0011H\u0007J\u0010\u0010)\u001a\u00020\u001c2\u0006\u0010*\u001a\u00020+H\u0007J\u000e\u0010,\u001a\u00020\u001c2\u0006\u0010(\u001a\u00020\u0011J\u0016\u0010-\u001a\u00020\u001c2\u0006\u0010*\u001a\u00020+2\u0006\u0010.\u001a\u00020\u001aJ\u0010\u0010/\u001a\u0004\u0018\u00010\u00112\u0006\u0010*\u001a\u00020+J\u0015\u00100\u001a\u0004\u0018\u00010\u001a2\u0006\u0010*\u001a\u00020+¢\u0006\u0002\u00101J\u0016\u00102\u001a\u0012\u0012\u0004\u0012\u00020\u00110\u0010j\b\u0012\u0004\u0012\u00020\u0011`\u0012J\u0010\u00103\u001a\u00020\u001a2\u0006\u0010\u001e\u001a\u00020\u001aH\u0016J\b\u00104\u001a\u00020\u001aH\u0016J\u0010\u00105\u001a\u0002062\u0006\u0010\u001e\u001a\u00020\u001aH\u0016J4\u00107\u001a\u0012\u0012\u0004\u0012\u00020\u00110\u0010j\b\u0012\u0004\u0012\u00020\u0011`\u00122\u001a\u0010%\u001a\u0016\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010j\n\u0012\u0004\u0012\u00020\u0011\u0018\u0001`\u0012H\u0002J8\u00108\u001a\u0002092\u0006\u0010:\u001a\u00020\u00112\u0006\u0010;\u001a\u00020\u00112\u0006\u0010<\u001a\u00020\u001a2\u0006\u0010=\u001a\u00020\u001a2\u0006\u0010>\u001a\u00020\u001a2\u0006\u0010?\u001a\u00020\u001aH\u0002J\u0014\u0010@\u001a\u00020+*\u00020\u00112\u0006\u0010\u001e\u001a\u00020\u001aH\u0002J\f\u0010A\u001a\u00020+*\u00020\u0011H\u0002J\f\u0010B\u001a\u000209*\u00020CH\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001e\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\u00110\u0010j\b\u0012\u0004\u0012\u00020\u0011`\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0015¨\u0006E"}, d2 = {"Lcom/larus/bmhome/view/resourcebar/ResourceBarAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/larus/bmhome/view/resourcebar/viewholder/BaseResourceViewHolder;", "config", "Lcom/larus/bmhome/view/resourcebar/bean/ResourceBarConfig;", "callback", "Lcom/larus/bmhome/view/resourcebar/viewholder/BaseResourceViewHolder$Callback;", "<init>", "(Lcom/larus/bmhome/view/resourcebar/bean/ResourceBarConfig;Lcom/larus/bmhome/view/resourcebar/viewholder/BaseResourceViewHolder$Callback;)V", "getConfig", "()Lcom/larus/bmhome/view/resourcebar/bean/ResourceBarConfig;", "setConfig", "(Lcom/larus/bmhome/view/resourcebar/bean/ResourceBarConfig;)V", "getCallback", "()Lcom/larus/bmhome/view/resourcebar/viewholder/BaseResourceViewHolder$Callback;", "list", "Ljava/util/ArrayList;", "Lcom/larus/bmhome/view/resourcebar/bean/ResourceItemBean;", "Lkotlin/collections/ArrayList;", "innerCallback", "com/larus/bmhome/view/resourcebar/ResourceBarAdapter$innerCallback$1", "Lcom/larus/bmhome/view/resourcebar/ResourceBarAdapter$innerCallback$1;", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "onBindViewHolder", "", "holder", "position", "payloads", "", "", "setSpecs", "updateConfig", "refresh", "items", "refreshCurrentItems", "addItem", MapController.ITEM_LAYER_TAG, "removeItem", "key", "", "refreshItem", "refreshUpLinkProgress", "upLinkProgress", "getItem", "getItemPosition", "(Ljava/lang/String;)Ljava/lang/Integer;", "getList", "getItemViewType", "getItemCount", "getItemId", "", "buildRefreshList", "isSameItem", "", "oldItem", "newItem", "oldItemPosition", "newItemPosition", "oldListSize", "newListSize", "stableId", "displayIdentity", "isMediaType", "Lcom/larus/bmhome/view/resourcebar/bean/ResourceType;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ResourceBarAdapter extends RecyclerView.Adapter<BaseResourceViewHolder> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ int f317142e = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ResourceBarConfig f317143a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final BaseResourceViewHolder.a f317144b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ArrayList<ResourceItemBean> f317145c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final lt8.a f317146d;

    public static final class a {
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f317147a = null;

        static {
            int[] r100 = new int[ResourceType.values().length];
            r100[ResourceType.IMAGE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r100[ResourceType.AVATAR.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r100[ResourceType.VIDEO.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            f317147a = r100;
        }
    }

    static {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return this.f317145c.size();
    }

    public static String y2(ResourceItemBean r100) {
        int r101 = b.f317147a[r100.getResourceType().ordinal()];
        boolean r102 = false;
        String r103 = null;
        if (r101 != 1) goto L5;
    L158:
        Object r104 = r100.getExt().get("ext_img_show_path");
        if ((r104 instanceof String) == false) goto L161;
        String r105 = (String) r104;
    L162:
        if (r105 != null) goto L164;
    L167:
        boolean r106 = true;
    L169:
        if ((!r106) == true) goto L172;
        r105 = null;
    L172:
        if (r105 != null) goto L254;
        Image r107 = r100.getImage();
        if (r107 == null) goto L176;
        r105 = r107.localResPath;
    L177:
        if (r105 != null) goto L179;
    L182:
        boolean r108 = true;
    L184:
        if ((!r108) == true) goto L187;
        r105 = null;
    L187:
        if (r105 != null) goto L254;
        Image r109 = r100.getImage();
        if (r109 == null) goto L191;
        r105 = r109.key;
    L192:
        if (r105 != null) goto L194;
    L197:
        boolean r110 = true;
    L199:
        if ((!r110) == true) goto L202;
        r105 = null;
    L202:
        if (r105 != null) goto L254;
        Image r111 = r100.getImage();
        if (r111 == null) goto L208;
        ImageObj r112 = r111.previewImage;
        if (r112 == null) goto L208;
        r105 = r112.url;
    L209:
        if (r105 != null) goto L211;
    L214:
        boolean r113 = true;
    L216:
        if ((!r113) == true) goto L219;
        r105 = null;
    L219:
        if (r105 != null) goto L254;
        Image r114 = r100.getImage();
        if (r114 == null) goto L225;
        ImageObj r115 = r114.imageThumb;
        if (r115 == null) goto L225;
        r105 = r115.url;
    L226:
        if (r105 != null) goto L228;
    L231:
        boolean r116 = true;
    L233:
        if ((!r116) == true) goto L236;
        r105 = null;
    L236:
        if (r105 != null) goto L254;
        Image r117 = r100.getImage();
        if (r117 == null) goto L242;
        ImageObj r118 = r117.imageOri;
        if (r118 == null) goto L242;
        String r119 = r118.url;
    L243:
        if (r119 != null) goto L245;
    L246:
        r102 = true;
    L248:
        if ((!r102) == false) goto L250;
        r103 = r119;
    L250:
        if (r103 != null) goto L257;
    L251:
        return "";
    L257:
        return r103;
    L245:
        if (StringsKt.isBlank(r119) == false) goto L248;
    L242:
        r119 = null;
        goto L243
    L228:
        if (StringsKt.isBlank(r105) == true) goto L231;
        r116 = false;
    L225:
        r105 = null;
        goto L226
    L211:
        if (StringsKt.isBlank(r105) == true) goto L214;
        r113 = false;
    L208:
        r105 = null;
        goto L209
    L194:
        if (StringsKt.isBlank(r105) == true) goto L197;
        r110 = false;
        goto L199
    L191:
        r105 = null;
        goto L192
    L179:
        if (StringsKt.isBlank(r105) == true) goto L182;
        r108 = false;
        goto L184
    L176:
        r105 = null;
    L254:
        return r105;
    L164:
        if (StringsKt.isBlank(r105) == true) goto L167;
        r106 = false;
        goto L169
    L161:
        r105 = null;
        goto L162
    L5:
        if (r101 == 2) goto L158;
        if (r101 != 3) goto L255;
        mt8.b r120 = r100.getVideo();
        if (r120 == null) goto L12;
        r105 = r120.f515654e;
    L13:
        if (r105 != null) goto L15;
    L18:
        boolean r121 = true;
    L20:
        if ((!r121) == true) goto L23;
        r105 = null;
    L23:
        if (r105 != null) goto L254;
        mt8.b r122 = r100.getVideo();
        if (r122 == null) goto L29;
        Image r123 = r122.f515650a;
        if (r123 == null) goto L29;
        r105 = r123.localResPath;
    L30:
        if (r105 != null) goto L32;
    L35:
        boolean r124 = true;
    L37:
        if ((!r124) == true) goto L40;
        r105 = null;
    L40:
        if (r105 != null) goto L254;
        mt8.b r125 = r100.getVideo();
        if (r125 == null) goto L44;
        r105 = r125.f515655f;
    L45:
        if (r105 != null) goto L47;
    L50:
        boolean r126 = true;
    L52:
        if ((!r126) == true) goto L55;
        r105 = null;
    L55:
        if (r105 != null) goto L254;
        mt8.b r127 = r100.getVideo();
        if (r127 == null) goto L59;
        r105 = r127.f515656g;
    L60:
        if (r105 != null) goto L62;
    L65:
        boolean r128 = true;
    L67:
        if ((!r128) == true) goto L70;
        r105 = null;
    L70:
        if (r105 != null) goto L254;
        mt8.b r129 = r100.getVideo();
        if (r129 == null) goto L74;
        r105 = r129.f515658i;
    L75:
        if (r105 != null) goto L77;
    L80:
        boolean r130 = true;
    L82:
        if ((!r130) == true) goto L85;
        r105 = null;
    L85:
        if (r105 != null) goto L254;
        mt8.b r131 = r100.getVideo();
        if (r131 == null) goto L91;
        Image r132 = r131.f515650a;
        if (r132 == null) goto L91;
        r105 = r132.key;
    L92:
        if (r105 != null) goto L94;
    L97:
        boolean r133 = true;
    L99:
        if ((!r133) == true) goto L102;
        r105 = null;
    L102:
        if (r105 != null) goto L254;
        mt8.b r134 = r100.getVideo();
        if (r134 == null) goto L110;
        Image r135 = r134.f515650a;
        if (r135 == null) goto L110;
        ImageObj r136 = r135.previewImage;
        if (r136 == null) goto L110;
        r105 = r136.url;
    L111:
        if (r105 != null) goto L113;
    L116:
        boolean r137 = true;
    L118:
        if ((!r137) == true) goto L121;
        r105 = null;
    L121:
        if (r105 != null) goto L254;
        mt8.b r138 = r100.getVideo();
        if (r138 == null) goto L129;
        Image r139 = r138.f515650a;
        if (r139 == null) goto L129;
        ImageObj r140 = r139.imageThumb;
        if (r140 == null) goto L129;
        r105 = r140.url;
    L130:
        if (r105 != null) goto L132;
    L135:
        boolean r141 = true;
    L137:
        if ((!r141) == true) goto L140;
        r105 = null;
    L140:
        if (r105 != null) goto L254;
        mt8.b r142 = r100.getVideo();
        if (r142 == null) goto L148;
        Image r143 = r142.f515650a;
        if (r143 == null) goto L148;
        ImageObj r144 = r143.imageOri;
        if (r144 == null) goto L148;
        String r145 = r144.url;
    L149:
        if (r145 != null) goto L151;
    L152:
        r102 = true;
    L154:
        if ((!r102) == false) goto L156;
        r103 = r145;
    L156:
        if (r103 != null) goto L257;
    L151:
        if (StringsKt.isBlank(r145) == false) goto L154;
    L148:
        r145 = null;
        goto L149
    L132:
        if (StringsKt.isBlank(r105) == true) goto L135;
        r141 = false;
    L129:
        r105 = null;
        goto L130
    L113:
        if (StringsKt.isBlank(r105) == true) goto L116;
        r137 = false;
    L110:
        r105 = null;
        goto L111
    L94:
        if (StringsKt.isBlank(r105) == true) goto L97;
        r133 = false;
    L91:
        r105 = null;
        goto L92
    L77:
        if (StringsKt.isBlank(r105) == true) goto L80;
        r130 = false;
        goto L82
    L74:
        r105 = null;
        goto L75
    L62:
        if (StringsKt.isBlank(r105) == true) goto L65;
        r128 = false;
        goto L67
    L59:
        r105 = null;
        goto L60
    L47:
        if (StringsKt.isBlank(r105) == true) goto L50;
        r126 = false;
        goto L52
    L44:
        r105 = null;
        goto L45
    L32:
        if (StringsKt.isBlank(r105) == true) goto L35;
        r124 = false;
    L29:
        r105 = null;
        goto L30
    L15:
        if (StringsKt.isBlank(r105) == true) goto L18;
        r121 = false;
        goto L20
    L12:
        r105 = null;
        goto L13
    L255:
        return r100.getKey();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final long getItemId(int r100) {
        ResourceItemBean r101 = (ResourceItemBean) CollectionsKt.getOrNull(this.f317145c, r100);
        if (r101 == null) goto L31;
        boolean r102 = false;
        if (this.f317143a.getMode() != Mode.SHOW) goto L17;
        ResourceType r103 = r101.getResourceType();
        if (r103 != ResourceType.IMAGE) goto L9;
    L14:
        boolean r104 = true;
    L15:
        if (r104 == false) goto L17;
        StringBuilder r105 = new StringBuilder();
        r105.append(r101.getResourceType().getValue());
        r105.append('_');
        r105.append(r100);
        String r106 = r105.toString();
    L28:
        if (r106 == null) goto L31;
        return r106.hashCode();
    L9:
        if (r103 == ResourceType.AVATAR) goto L14;
        if (r103 == ResourceType.VIDEO) goto L14;
        r104 = false;
    L17:
        String r107 = r101.getKey();
        if ((!StringsKt.isBlank(r107)) == true) goto L21;
        r107 = null;
    L21:
        if (r107 != null) goto L27;
        r107 = y2(r101);
        if (r107.length() != 0) goto L25;
        r102 = true;
    L25:
        if (r102 == false) goto L27;
        StringBuilder r108 = new StringBuilder();
        r108.append(r101.getResourceType().getValue());
        r108.append('_');
        r108.append(r100);
        r106 = r108.toString();
    L27:
        r106 = r107;
    L31:
        return super.getItemId(r100);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemViewType(int r100) {
        ResourceItemBean r101 = (ResourceItemBean) CollectionsKt.getOrNull(this.f317145c, r100);
        if (r101 == null) goto L7;
        ResourceType r102 = r101.getResourceType();
        if (r102 == null) goto L7;
    L9:
        return r102.getValue();
    L7:
        r102 = ResourceType.FILE;
        goto L9
    }

    public final Integer z2(String r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Iterator<T> r101 = this.f317145c.iterator();
        int r102 = 0;
    L4:
        if (r101.hasNext() == false) goto L13;
        Object r103 = r101.next();
        int r104 = r102 + 1;
        if (r102 >= 0) goto L9;
        CollectionsKt.throwIndexOverflow();
    L9:
        if (Intrinsics.areEqual(r100, ((ResourceItemBean) r103).getKey()) == true) goto L11;
        r102 = r104;
        goto L4
    L11:
        return Integer.valueOf(r102);
    L13:
        return null;
    }

    public ResourceBarAdapter(ResourceBarConfig r100, ResourceBar.b r101) {
        Intrinsics.checkNotNullParameter(r100, "config");
        this.f317143a = r100;
        this.f317144b = r101;
        this.f317145c = new ArrayList();
        setHasStableIds(true);
        this.f317146d = new lt8.a(this);
    }

    public final void A2(BaseResourceViewHolder r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "holder");
        ResourceBarConfig r102 = this.f317143a;
        r100.getClass();
        Intrinsics.checkNotNullParameter(r102, "<set-?>");
        r100.f317159a = r102;
        ViewGroup.LayoutParams r103 = r100.itemView.getLayoutParams();
        if ((r103 instanceof ViewGroup.MarginLayoutParams) == false) goto L5;
        ViewGroup.MarginLayoutParams r104 = (ViewGroup.MarginLayoutParams) r103;
    L6:
        if (r104 == null) goto L15;
        int r105 = 0;
        if (r101 != 0) goto L10;
        int r106 = r100.f317159a.getMarginStart();
    L11:
        r104.setMarginStart(r106);
        if (CollectionsKt.getLastIndex(this.f317145c) != r101) goto L14;
        r105 = r100.f317159a.getMarginEnd() - i5.r0();
    L14:
        r104.setMarginEnd(r105);
        goto L15
    L10:
        r106 = 0;
    L15:
        ResourceItemBean r107 = (ResourceItemBean) CollectionsKt.getOrNull(this.f317145c, r101);
        if (r107 == null) goto L19;
        r100.T3(r107, this.f317146d);
        return;
    L19:
        return;
    L5:
        r104 = null;
        goto L6
    }

    public final void B2(String r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Integer r102 = z2(r100);
        if (r102 == null) goto L9;
        int r103 = r102.intValue();
        ResourceItemBean r104 = (ResourceItemBean) CollectionsKt.getOrNull(this.f317145c, r103);
        if (r104 == null) goto L7;
        r104.setUpLinkProgress(r101);
    L7:
        notifyItemChanged(r103);
        return;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final /* bridge */ /* synthetic */ void onBindViewHolder(RecyclerView.ViewHolder r100, int r101) {
        A2((BaseResourceViewHolder) r100, r101);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        if (r101 != ResourceType.ADD.getValue()) goto L10;
        ResourceBarConfig r102 = this.f317143a;
        View r103 = LayoutInflater.from(r100.getContext()).inflate(R.layout.larus_add_resource_item_view, r100, false);
        if (r103 == null) goto L8;
        RecyclerView.ViewHolder r104 = new AddResourceViewHolder(r102, new LarusAddResourceItemViewBinding((ConstraintLayout) r103));
    L25:
        d.a().ta(r101, r104.itemView);
        return r104;
    L8:
        throw new NullPointerException("rootView");
    L10:
        if (r101 != ResourceType.IMAGE.getValue()) goto L12;
    L24:
        r104 = new ImgResourceViewHolder(this.f317143a, LarusFileResourceItemViewBinding.a(LayoutInflater.from(r100.getContext()), r100));
        goto L25
    L12:
        if (r101 == ResourceType.AVATAR.getValue()) goto L24;
        if (r101 != ResourceType.AUDIO.getValue()) goto L18;
        r104 = new AudioResourceViewHolder(this.f317143a, LarusFileResourceItemViewBinding.a(LayoutInflater.from(r100.getContext()), r100));
        goto L25
    L18:
        if (r101 != ResourceType.VIDEO.getValue()) goto L20;
        r104 = new VideoResourceViewHolder(this.f317143a, LarusFileResourceItemViewBinding.a(LayoutInflater.from(r100.getContext()), r100));
        goto L25
    L20:
        Function2<ResourceBarConfig, ViewGroup, BaseResourceViewHolder> r105 = this.f317143a.getCustomRender().get(Integer.valueOf(r101));
        if (r105 != null) goto L27;
        r104 = new FileResourceViewHolder(this.f317143a, LarusFileResourceItemViewBinding.a(LayoutInflater.from(r100.getContext()), r100));
        goto L25
    L27:
        return r105.invoke(this.f317143a, r100);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r101, List r102) {
        BaseResourceViewHolder r103 = (BaseResourceViewHolder) r100;
        Intrinsics.checkNotNullParameter(r103, "holder");
        Intrinsics.checkNotNullParameter(r102, "payloads");
        if ((r103 instanceof PayloadResourceViewHolder) == true) goto L5;
    L9:
        A2(r103, r101);
        return;
    L5:
        if ((!r102.isEmpty()) == false) goto L9;
        if (((ResourceItemBean) CollectionsKt.getOrNull(this.f317145c, r101)) == null) goto L11;
        ((PayloadResourceViewHolder) r103).U3(r102);
        return;
    }
}
