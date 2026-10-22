package com.larus.bmhome.chat.deepresearch.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.gson.Gson;
import com.larus.bmhome.chat.deepresearch.module.ImageBlock;
import com.larus.im.bean.message.SearchImageInfo;
import com.larus.im.bean.message.TextCard;
import com.larus.im.bean.message.block.BannerBlock;
import com.larus.im.bean.message.block.Block;
import com.larus.im.bean.message.block.BlockContent;
import com.larus.im.bean.message.block.CodeBlock;
import com.larus.im.bean.message.block.GenImageBlock;
import com.larus.im.bean.message.block.LinkReaderBlock;
import com.larus.im.bean.message.block.LocalLifeBlock;
import com.larus.im.bean.message.block.ResearchStatusBlock;
import com.larus.im.bean.message.block.RoutePlanBlock;
import com.larus.im.bean.message.block.SearchQueryBlock;
import com.larus.im.bean.message.block.SearchResultBlock;
import com.larus.im.bean.message.block.TextBlock;
import com.larus.im.bean.message.block.VideoReaderBlock;
import com.larus.image.loader.ImageLoaderKt;
import com.larus.nova.R;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0003\b&\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ\u001a\u0010\f\u001a\u00020\r2\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&J*\u0010\u000e\u001a\u00020\r2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0016\b\u0002\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0012H&J\b\u0010\u0015\u001a\u00020\rH\u0016¨\u0006\u0017"}, d2 = {"Lcom/larus/bmhome/chat/deepresearch/view/AbsBlockView;", "Landroid/widget/LinearLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "init", "", "bindData", "data", "Lcom/larus/im/bean/message/block/Block;", "extra", "", "", "", "onViewRecycled", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class AbsBlockView extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f302227a = 0;

    public static final class a {
        public static GenImageBlock a(Block r100) {
            if (r100 == null) goto L6;
            BlockContent r101 = r100.getContent();
            if (r101 == null) goto L6;
            return r101.getGenImageBlock();
        L6:
            return null;
        }

        public static ImageBlock b(Block r100) {
            if (r100 != null) goto L4;
        L6:
            boolean r101 = false;
        L7:
            String r102 = null;
            if (r101 == true) goto L10;
            return null;
        L10:
            ImageBlock r103 = (ImageBlock) com.larus.utils.l.b(r100, "extra_key_image_block");
            if (r103 != null) goto L17;
            Gson r104 = new Gson();
            BlockContent r105 = r100.getContent();
            if (r105 == null) goto L15;
            r102 = r105.getImageBlock();
        L15:
            ImageBlock r106 = (ImageBlock) GsonProtectorUtils.fromJson(r104, r102, ImageBlock.class);
            com.larus.utils.l.c(r100, "extra_key_image_block", r106);
            return r106;
        L17:
            return r103;
        L4:
            if (r100.getBlockType() != j.f302439s) goto L6;
            r101 = true;
            goto L7
        }

        public static List c(Block r100) {
            Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L27
            if (r100 == null) goto L6;
            Integer r102 = Integer.valueOf(r100.getBlockType());     // Catch: Throwable -> L27
        L7:
            int r103 = j.f302439s;     // Catch: Throwable -> L27
            if (r102 != null) goto L11;
        L18:
            int r104 = j.f302435q;     // Catch: Throwable -> L27
            if (r102 != null) goto L22;
            return null;
        L22:
            if (r102.intValue() != r104) goto L36;
            int r105 = AbsBlockView.f302227a;     // Catch: Throwable -> L27
            GenImageBlock r106 = a(r100);     // Catch: Throwable -> L27
            if (r106 != null) goto L26;
            return null;
        L26:
            return r106.images;
        L36:
            return null;
        L11:
            if (r102.intValue() != r103) goto L18;
            int r107 = AbsBlockView.f302227a;     // Catch: Throwable -> L27
            ImageBlock r108 = b(r100);     // Catch: Throwable -> L27
            if (r108 == null) goto L33;
            List<SearchImageInfo> r109 = r108.images;     // Catch: Throwable -> L27
            if (r109 != null) goto L17;
            return null;
        L17:
            return CollectionsKt.filterNotNull(r109);
        L33:
            return null;
        L6:
            r102 = null;
        L27:
            th = move-exception;
            Result.Companion r110 = Result.Companion;
            Throwable r111 = Result.m9452exceptionOrNullimpl(Result.m9449constructorimpl(ResultKt.createFailure(th)));
            if (r111 == null) goto L31;
            FLogger.f375446a.i("AbsBlockView", r111.toString());
        L31:
            return null;
        }

        public static String d(Block r100) {
            Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L102
            if (r100 == null) goto L6;
            Integer r102 = Integer.valueOf(r100.getBlockType());     // Catch: Throwable -> L102
        L7:
            int r103 = j.f302431o;     // Catch: Throwable -> L102
            if (r102 != null) goto L11;
        L18:
            int r104 = j.f302439s;     // Catch: Throwable -> L102
            if (r102 != null) goto L22;
        L27:
            int r105 = j.f302435q;     // Catch: Throwable -> L102
            if (r102 != null) goto L31;
        L36:
            int r106 = j.f302433p;     // Catch: Throwable -> L102
            if (r102 != null) goto L40;
        L47:
            int r107 = j.f302429n;     // Catch: Throwable -> L102
            if (r102 != null) goto L51;
        L58:
            int r108 = j.f302427m;     // Catch: Throwable -> L102
            if (r102 != null) goto L62;
        L69:
            int r109 = j.f302423k;     // Catch: Throwable -> L102
            if (r102 != null) goto L73;
        L80:
            int r110 = j.f302425l;     // Catch: Throwable -> L102
            if (r102 != null) goto L84;
        L91:
            int r111 = j.f302444x;     // Catch: Throwable -> L102
            if (r102 != null) goto L95;
            return null;
        L95:
            if (r102.intValue() != r111) goto L123;
            BlockContent r112 = r100.getContent();     // Catch: Throwable -> L102
            if (r112 == null) goto L124;
            RoutePlanBlock r113 = r112.getRoutePlanBlock();     // Catch: Throwable -> L102
            if (r113 != null) goto L101;
            return null;
        L101:
            return r113.toolName;
        L124:
            return null;
        L123:
            return null;
        L84:
            if (r102.intValue() != r110) goto L91;
            BlockContent r114 = r100.getContent();     // Catch: Throwable -> L102
            if (r114 == null) goto L120;
            SearchResultBlock r115 = r114.getSearchResultBlock();     // Catch: Throwable -> L102
            if (r115 != null) goto L90;
            return null;
        L90:
            return r115.toolName;
        L120:
            return null;
        L73:
            if (r102.intValue() != r109) goto L80;
            BlockContent r116 = r100.getContent();     // Catch: Throwable -> L102
            if (r116 == null) goto L118;
            SearchQueryBlock r117 = r116.getSearchQueryBlock();     // Catch: Throwable -> L102
            if (r117 != null) goto L79;
            return null;
        L79:
            return r117.toolName;
        L118:
            return null;
        L62:
            if (r102.intValue() != r108) goto L69;
            BlockContent r118 = r100.getContent();     // Catch: Throwable -> L102
            if (r118 == null) goto L116;
            LinkReaderBlock r119 = r118.getLinkReaderBlock();     // Catch: Throwable -> L102
            if (r119 != null) goto L68;
            return null;
        L68:
            return r119.toolName;
        L116:
            return null;
        L51:
            if (r102.intValue() != r107) goto L58;
            BlockContent r120 = r100.getContent();     // Catch: Throwable -> L102
            if (r120 == null) goto L114;
            VideoReaderBlock r121 = r120.getVideoReaderBlock();     // Catch: Throwable -> L102
            if (r121 != null) goto L57;
            return null;
        L57:
            return r121.toolName;
        L114:
            return null;
        L40:
            if (r102.intValue() != r106) goto L47;
            BlockContent r122 = r100.getContent();     // Catch: Throwable -> L102
            if (r122 == null) goto L112;
            LocalLifeBlock r123 = r122.getLocalLifeBlock();     // Catch: Throwable -> L102
            if (r123 != null) goto L46;
            return null;
        L46:
            return r123.toolName;
        L112:
            return null;
        L31:
            if (r102.intValue() != r105) goto L36;
            int r124 = AbsBlockView.f302227a;     // Catch: Throwable -> L102
            GenImageBlock r125 = a(r100);     // Catch: Throwable -> L102
            if (r125 != null) goto L35;
            return null;
        L35:
            return r125.toolName;
        L22:
            if (r102.intValue() != r104) goto L27;
            int r126 = AbsBlockView.f302227a;     // Catch: Throwable -> L102
            ImageBlock r127 = b(r100);     // Catch: Throwable -> L102
            if (r127 != null) goto L26;
            return null;
        L26:
            return r127.toolName;
        L11:
            if (r102.intValue() != r103) goto L18;
            BlockContent r128 = r100.getContent();     // Catch: Throwable -> L102
            if (r128 == null) goto L108;
            CodeBlock r129 = r128.getCodeBlock();     // Catch: Throwable -> L102
            if (r129 != null) goto L17;
            return null;
        L17:
            return r129.toolName;
        L108:
            return null;
        L6:
            r102 = null;
        L102:
            th = move-exception;
            Result.Companion r130 = Result.Companion;
            Throwable r131 = Result.m9452exceptionOrNullimpl(Result.m9449constructorimpl(ResultKt.createFailure(th)));
            if (r131 == null) goto L106;
            FLogger.f375446a.i("AbsBlockView", r131.toString());
        L106:
            return null;
        }

        public static void e(SimpleDraweeView r100, Block r101) {
            if (r100 == null) goto L239;
            if (r101 == null) goto L260;
            Context r102 = r100.getContext();
            if (r102 != null) goto L8;
            return;
        L8:
            int r103 = r101.getBlockType();
            String r104 = null;
            if (r103 != j.f302411e) goto L31;
            boolean r105 = v19.h.f552477a;
            if (v19.h.b(r102) == true) goto L21;
            GenericDraweeHierarchy r106 = r100.getHierarchy();
            if (r106 == null) goto L15;
            r106.setPlaceholderImage(R.drawable.larus_item_deep_research_generate_icon);
        L15:
            BlockContent r107 = r101.getContent();
            if (r107 == null) goto L20;
            TextBlock r108 = r107.getTextBlock();
            if (r108 == null) goto L20;
            r104 = r108.iconUrl;
        L20:
            ImageLoaderKt.u(r100, r104, "deep_research");
            return;
        L21:
            GenericDraweeHierarchy r109 = r100.getHierarchy();
            if (r109 == null) goto L24;
            r109.setPlaceholderImage(R.drawable.larus_item_deep_research_generate_icon_dark);
        L24:
            BlockContent r110 = r101.getContent();
            if (r110 == null) goto L29;
            TextBlock r111 = r110.getTextBlock();
            if (r111 == null) goto L29;
            r104 = r111.iconUrlDark;
        L29:
            ImageLoaderKt.u(r100, r104, "deep_research");
            return;
        L31:
            if (r103 != j.f302423k) goto L53;
            boolean r112 = v19.h.f552477a;
            if (v19.h.b(r102) == true) goto L43;
            GenericDraweeHierarchy r113 = r100.getHierarchy();
            if (r113 == null) goto L37;
            r113.setPlaceholderImage(R.drawable.larus_item_deep_research_icon);
        L37:
            BlockContent r114 = r101.getContent();
            if (r114 == null) goto L42;
            SearchResultBlock r115 = r114.getSearchResultBlock();
            if (r115 == null) goto L42;
            r104 = r115.iconUrl;
        L42:
            ImageLoaderKt.u(r100, r104, "deep_research");
            return;
        L43:
            GenericDraweeHierarchy r116 = r100.getHierarchy();
            if (r116 == null) goto L46;
            r116.setPlaceholderImage(R.drawable.larus_item_deep_research_icon_dark);
        L46:
            BlockContent r117 = r101.getContent();
            if (r117 == null) goto L51;
            SearchResultBlock r118 = r117.getSearchResultBlock();
            if (r118 == null) goto L51;
            r104 = r118.iconUrlDark;
        L51:
            ImageLoaderKt.u(r100, r104, "deep_research");
            return;
        L53:
            if (r103 != j.f302425l) goto L75;
            boolean r119 = v19.h.f552477a;
            if (v19.h.b(r102) == true) goto L65;
            GenericDraweeHierarchy r120 = r100.getHierarchy();
            if (r120 == null) goto L59;
            r120.setPlaceholderImage(R.drawable.larus_item_deep_research_link_icon);
        L59:
            BlockContent r121 = r101.getContent();
            if (r121 == null) goto L64;
            SearchResultBlock r122 = r121.getSearchResultBlock();
            if (r122 == null) goto L64;
            r104 = r122.iconUrl;
        L64:
            ImageLoaderKt.u(r100, r104, "deep_research");
            return;
        L65:
            GenericDraweeHierarchy r123 = r100.getHierarchy();
            if (r123 == null) goto L68;
            r123.setPlaceholderImage(R.drawable.larus_item_deep_research_link_icon_dark);
        L68:
            BlockContent r124 = r101.getContent();
            if (r124 == null) goto L73;
            SearchResultBlock r125 = r124.getSearchResultBlock();
            if (r125 == null) goto L73;
            r104 = r125.iconUrlDark;
        L73:
            ImageLoaderKt.u(r100, r104, "deep_research");
            return;
        L75:
            if (r103 != j.f302427m) goto L97;
            boolean r126 = v19.h.f552477a;
            if (v19.h.b(r102) == true) goto L87;
            GenericDraweeHierarchy r127 = r100.getHierarchy();
            if (r127 == null) goto L81;
            r127.setPlaceholderImage(R.drawable.larus_item_deep_research_read_icon);
        L81:
            BlockContent r128 = r101.getContent();
            if (r128 == null) goto L86;
            LinkReaderBlock r129 = r128.getLinkReaderBlock();
            if (r129 == null) goto L86;
            r104 = r129.iconUrl;
        L86:
            ImageLoaderKt.u(r100, r104, "deep_research");
            return;
        L87:
            GenericDraweeHierarchy r130 = r100.getHierarchy();
            if (r130 == null) goto L90;
            r130.setPlaceholderImage(R.drawable.larus_item_deep_research_read_icon_dark);
        L90:
            BlockContent r131 = r101.getContent();
            if (r131 == null) goto L95;
            LinkReaderBlock r132 = r131.getLinkReaderBlock();
            if (r132 == null) goto L95;
            r104 = r132.iconUrlDark;
        L95:
            ImageLoaderKt.u(r100, r104, "deep_research");
            return;
        L97:
            if (r103 != j.f302429n) goto L119;
            boolean r133 = v19.h.f552477a;
            if (v19.h.b(r102) == true) goto L109;
            GenericDraweeHierarchy r134 = r100.getHierarchy();
            if (r134 == null) goto L103;
            r134.setPlaceholderImage(R.drawable.larus_item_deep_research_video_icon);
        L103:
            BlockContent r135 = r101.getContent();
            if (r135 == null) goto L108;
            VideoReaderBlock r136 = r135.getVideoReaderBlock();
            if (r136 == null) goto L108;
            r104 = r136.iconUrl;
        L108:
            ImageLoaderKt.u(r100, r104, "deep_research");
            return;
        L109:
            GenericDraweeHierarchy r137 = r100.getHierarchy();
            if (r137 == null) goto L112;
            r137.setPlaceholderImage(R.drawable.larus_item_deep_research_video_icon_dark);
        L112:
            BlockContent r138 = r101.getContent();
            if (r138 == null) goto L117;
            VideoReaderBlock r139 = r138.getVideoReaderBlock();
            if (r139 == null) goto L117;
            r104 = r139.iconUrlDark;
        L117:
            ImageLoaderKt.u(r100, r104, "deep_research");
            return;
        L119:
            if (r103 != j.f302431o) goto L141;
            boolean r140 = v19.h.f552477a;
            if (v19.h.b(r102) == true) goto L131;
            GenericDraweeHierarchy r141 = r100.getHierarchy();
            if (r141 == null) goto L125;
            r141.setPlaceholderImage(R.drawable.larus_item_deep_research_code_icon);
        L125:
            BlockContent r142 = r101.getContent();
            if (r142 == null) goto L130;
            CodeBlock r143 = r142.getCodeBlock();
            if (r143 == null) goto L130;
            r104 = r143.iconUrl;
        L130:
            ImageLoaderKt.u(r100, r104, "deep_research");
            return;
        L131:
            GenericDraweeHierarchy r144 = r100.getHierarchy();
            if (r144 == null) goto L134;
            r144.setPlaceholderImage(R.drawable.larus_item_deep_research_code_icon_dark);
        L134:
            BlockContent r145 = r101.getContent();
            if (r145 == null) goto L139;
            CodeBlock r146 = r145.getCodeBlock();
            if (r146 == null) goto L139;
            r104 = r146.iconUrlDark;
        L139:
            ImageLoaderKt.u(r100, r104, "deep_research");
            return;
        L141:
            if (r103 != j.f302433p) goto L163;
            boolean r147 = v19.h.f552477a;
            if (v19.h.b(r102) == true) goto L153;
            GenericDraweeHierarchy r148 = r100.getHierarchy();
            if (r148 == null) goto L147;
            r148.setPlaceholderImage(R.drawable.larus_item_deep_research_location_icon);
        L147:
            BlockContent r149 = r101.getContent();
            if (r149 == null) goto L152;
            LocalLifeBlock r150 = r149.getLocalLifeBlock();
            if (r150 == null) goto L152;
            r104 = r150.iconUrl;
        L152:
            ImageLoaderKt.u(r100, r104, "deep_research");
            return;
        L153:
            GenericDraweeHierarchy r151 = r100.getHierarchy();
            if (r151 == null) goto L156;
            r151.setPlaceholderImage(R.drawable.larus_item_deep_research_location_icon_dark);
        L156:
            BlockContent r152 = r101.getContent();
            if (r152 == null) goto L161;
            LocalLifeBlock r153 = r152.getLocalLifeBlock();
            if (r153 == null) goto L161;
            r104 = r153.iconUrlDark;
        L161:
            ImageLoaderKt.u(r100, r104, "deep_research");
            return;
        L163:
            if (r103 != j.f302435q) goto L183;
            Result.Companion r154 = Result.Companion;     // Catch: Throwable -> L180
            int r155 = AbsBlockView.f302227a;     // Catch: Throwable -> L180
            GenImageBlock r156 = a(r101);     // Catch: Throwable -> L180
            boolean r157 = v19.h.f552477a;     // Catch: Throwable -> L180
            if (v19.h.b(r102) == true) goto L172;
            GenericDraweeHierarchy r158 = r100.getHierarchy();     // Catch: Throwable -> L180
            if (r158 == null) goto L169;
            r158.setPlaceholderImage(R.drawable.larus_item_deep_research_image_icon);     // Catch: Throwable -> L180
        L169:
            if (r156 == null) goto L171;
            r104 = r156.iconUrl;     // Catch: Throwable -> L180
        L171:
            ImageLoaderKt.u(r100, r104, "deep_research");     // Catch: Throwable -> L180
        L178:
            Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L180
            return;
        L172:
            GenericDraweeHierarchy r159 = r100.getHierarchy();     // Catch: Throwable -> L180
            if (r159 == null) goto L175;
            r159.setPlaceholderImage(R.drawable.larus_item_deep_research_image_icon_dark);     // Catch: Throwable -> L180
        L175:
            if (r156 == null) goto L177;
            r104 = r156.iconUrlDark;     // Catch: Throwable -> L180
        L177:
            ImageLoaderKt.u(r100, r104, "deep_research");     // Catch: Throwable -> L180
        L180:
            th = move-exception;
            Result.Companion r160 = Result.Companion;
            Result.m9449constructorimpl(ResultKt.createFailure(th));
            return;
        L183:
            if (r103 != j.f302439s) goto L203;
            Result.Companion r161 = Result.Companion;     // Catch: Throwable -> L200
            int r162 = AbsBlockView.f302227a;     // Catch: Throwable -> L200
            ImageBlock r163 = b(r101);     // Catch: Throwable -> L200
            boolean r164 = v19.h.f552477a;     // Catch: Throwable -> L200
            if (v19.h.b(r102) == true) goto L192;
            GenericDraweeHierarchy r165 = r100.getHierarchy();     // Catch: Throwable -> L200
            if (r165 == null) goto L189;
            r165.setPlaceholderImage(R.drawable.larus_item_deep_research_image_icon);     // Catch: Throwable -> L200
        L189:
            if (r163 == null) goto L191;
            r104 = r163.iconUrl;     // Catch: Throwable -> L200
        L191:
            ImageLoaderKt.u(r100, r104, "deep_research");     // Catch: Throwable -> L200
        L198:
            Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L200
            return;
        L192:
            GenericDraweeHierarchy r166 = r100.getHierarchy();     // Catch: Throwable -> L200
            if (r166 == null) goto L195;
            r166.setPlaceholderImage(R.drawable.larus_item_deep_research_image_icon_dark);     // Catch: Throwable -> L200
        L195:
            if (r163 == null) goto L197;
            r104 = r163.iconUrlDark;     // Catch: Throwable -> L200
        L197:
            ImageLoaderKt.u(r100, r104, "deep_research");     // Catch: Throwable -> L200
        L200:
            th = move-exception;
            Result.Companion r167 = Result.Companion;
            Result.m9449constructorimpl(ResultKt.createFailure(th));
            return;
        L203:
            if (r103 != j.f302441u) goto L219;
            boolean r168 = v19.h.f552477a;
            if (v19.h.b(r102) == true) goto L212;
            BlockContent r169 = r101.getContent();
            if (r169 == null) goto L211;
            ResearchStatusBlock r170 = r169.getResearchStatusBlock();
            if (r170 == null) goto L211;
            r104 = r170.iconUrl;
        L211:
            ImageLoaderKt.u(r100, r104, "deep_research");
            return;
        L212:
            BlockContent r171 = r101.getContent();
            if (r171 == null) goto L217;
            ResearchStatusBlock r172 = r171.getResearchStatusBlock();
            if (r172 == null) goto L217;
            r104 = r172.iconUrlDark;
        L217:
            ImageLoaderKt.u(r100, r104, "deep_research");
            return;
        L219:
            if (r103 != j.f302444x) goto L258;
            boolean r173 = v19.h.f552477a;
            if (v19.h.b(r102) == true) goto L228;
            BlockContent r174 = r101.getContent();
            if (r174 == null) goto L227;
            RoutePlanBlock r175 = r174.getRoutePlanBlock();
            if (r175 == null) goto L227;
            r104 = r175.iconUrl;
        L227:
            ImageLoaderKt.u(r100, r104, "deep_research");
            return;
        L228:
            BlockContent r176 = r101.getContent();
            if (r176 == null) goto L233;
            RoutePlanBlock r177 = r176.getRoutePlanBlock();
            if (r177 == null) goto L233;
            r104 = r177.iconUrlDark;
        L233:
            ImageLoaderKt.u(r100, r104, "deep_research");
            return;
        L258:
            return;
        L260:
            return;
        }

        public static String f(Block r110, boolean r111, boolean r112) {
            if (r110 == null) goto L5;
            Integer r100 = Integer.valueOf(r110.getBlockType());
        L6:
            int r101 = j.f302411e;
            if (r100 != null) goto L10;
        L13:
            int r102 = j.f302435q;
            if (r100 != null) goto L17;
        L27:
            int r103 = j.f302439s;
            if (r100 != null) goto L31;
        L43:
            int r104 = j.f302433p;
            if (r100 != null) goto L47;
        L55:
            int r105 = j.f302429n;
            if (r100 != null) goto L59;
        L67:
            int r106 = j.f302431o;
            if (r100 != null) goto L71;
        L87:
            int r113 = j.f302441u;
            String r107 = "";
            if (r100 != null) goto L91;
        L100:
            int r114 = j.f302419i;
            if (r100 != null) goto L104;
        L112:
            int r115 = j.f302423k;
            if (r100 != null) goto L116;
        L128:
            int r116 = j.f302427m;
            if (r100 != null) goto L132;
        L158:
            int r117 = j.f302444x;
            if (r100 != null) goto L162;
            return null;
        L162:
            if (r100.intValue() != r117) goto L198;
            if (r110 == null) goto L199;
            BlockContent r118 = r110.getContent();
            if (r118 == null) goto L200;
            RoutePlanBlock r119 = r118.getRoutePlanBlock();
            if (r119 != null) goto L169;
            return null;
        L169:
            return r119.summary;
        L200:
            return null;
        L199:
            return null;
        L198:
            return null;
        L132:
            if (r100.intValue() != r116) goto L158;
            BlockContent r120 = r110.getContent();
            if (r120 == null) goto L140;
            LinkReaderBlock r121 = r120.getLinkReaderBlock();
            if (r121 == null) goto L140;
            List<TextCard> r122 = r121.items;
            if (r122 == null) goto L140;
            TextCard r123 = (TextCard) CollectionsKt.firstOrNull(r122);
        L141:
            if (r123 != null) goto L148;
            BlockContent r124 = r110.getContent();
            if (r124 == null) goto L196;
            LinkReaderBlock r125 = r124.getLinkReaderBlock();
            if (r125 != null) goto L147;
            return null;
        L147:
            return r125.summary;
        L196:
            return null;
        L148:
            StringCompanionObject r126 = StringCompanionObject.INSTANCE;
            BlockContent r127 = r110.getContent();
            if (r127 == null) goto L157;
            LinkReaderBlock r128 = r127.getLinkReaderBlock();
            if (r128 == null) goto L157;
            String r129 = r128.summary;
            if (r129 == null) goto L157;
            r107 = r129;
        L157:
            return String.format(r107, Arrays.copyOf(new Object[]{r123}, 1));
        L140:
            r123 = null;
            goto L141
        L116:
            if (r100.intValue() != r115) goto L128;
            if (r110.isFinish() == true) goto L120;
            return "";
        L120:
            BlockContent r130 = r110.getContent();
            if (r130 == null) goto L193;
            SearchQueryBlock r131 = r130.getSearchQueryBlock();
            if (r131 == null) goto L194;
            List<String> r132 = r131.queries;
            if (r132 != null) goto L127;
            return null;
        L127:
            return CollectionsKt.joinToString$default(r132, "、", null, null, 0, null, new com.larus.bmhome.chat.deepresearch.view.a(), 30, null);
        L194:
            return null;
        L193:
            return null;
        L104:
            if (r100.intValue() != r114) goto L112;
            if (r110 == null) goto L190;
            BlockContent r133 = r110.getContent();
            if (r133 == null) goto L191;
            BannerBlock r134 = r133.getBannerBlock();
            if (r134 != null) goto L111;
            return null;
        L111:
            return r134.summary;
        L191:
            return null;
        L190:
            return null;
        L91:
            if (r100.intValue() != r113) goto L100;
            if (r111 == true) goto L94;
            return "";
        L94:
            BlockContent r135 = r110.getContent();
            if (r135 == null) goto L188;
            ResearchStatusBlock r136 = r135.getResearchStatusBlock();
            if (r136 != null) goto L99;
            return null;
        L99:
            return r136.summary;
        L188:
            return null;
        L71:
            if (r100.intValue() != r106) goto L87;
            if (r112 == false) goto L80;
            if (r110 == null) goto L182;
            BlockContent r137 = r110.getContent();
            if (r137 == null) goto L183;
            CodeBlock r138 = r137.getCodeBlock();
            if (r138 != null) goto L79;
            return null;
        L79:
            return r138.code;
        L183:
            return null;
        L182:
            return null;
        L80:
            if (r110 == null) goto L185;
            BlockContent r139 = r110.getContent();
            if (r139 == null) goto L186;
            CodeBlock r140 = r139.getCodeBlock();
            if (r140 != null) goto L86;
            return null;
        L86:
            return r140.summary;
        L186:
            return null;
        L185:
            return null;
        L59:
            if (r100.intValue() != r105) goto L67;
            if (r110 == null) goto L179;
            BlockContent r141 = r110.getContent();
            if (r141 == null) goto L180;
            VideoReaderBlock r142 = r141.getVideoReaderBlock();
            if (r142 != null) goto L66;
            return null;
        L66:
            return r142.summary;
        L180:
            return null;
        L179:
            return null;
        L47:
            if (r100.intValue() != r104) goto L55;
            if (r110 == null) goto L176;
            BlockContent r143 = r110.getContent();
            if (r143 == null) goto L177;
            LocalLifeBlock r144 = r143.getLocalLifeBlock();
            if (r144 != null) goto L54;
            return null;
        L54:
            return r144.summary;
        L177:
            return null;
        L176:
            return null;
        L31:
            if (r100.intValue() != r103) goto L43;
            Result.Companion r145 = Result.Companion;     // Catch: Throwable -> L40
            Gson r146 = new Gson();     // Catch: Throwable -> L40
            if (r110 == null) goto L37;
            BlockContent r147 = r110.getContent();     // Catch: Throwable -> L40
            if (r147 == null) goto L37;
            String r148 = r147.getImageBlock();     // Catch: Throwable -> L40
        L38:
            return ((ImageBlock) r146.fromJson(r148, ImageBlock.class)).summary;
        L37:
            r148 = null;
        L40:
            th = move-exception;
            Result.Companion r149 = Result.Companion;
            Result.m9452exceptionOrNullimpl(Result.m9449constructorimpl(ResultKt.createFailure(th)));
            return null;
        L17:
            if (r100.intValue() != r102) goto L27;
            Result.Companion r150 = Result.Companion;     // Catch: Throwable -> L24
            BlockContent r151 = r110.getContent();     // Catch: Throwable -> L24
            if (r151 == null) goto L174;
            GenImageBlock r152 = r151.getGenImageBlock();     // Catch: Throwable -> L24
            if (r152 == null) goto L175;
            return r152.summary;
        L175:
            return null;
        L174:
            return null;
        L24:
            th = move-exception;
            Result.Companion r153 = Result.Companion;
            Result.m9452exceptionOrNullimpl(Result.m9449constructorimpl(ResultKt.createFailure(th)));
            return null;
        L10:
            if (r100.intValue() != r101) goto L13;
            return qf8.a.c(r110, null, 3);
        L5:
            r100 = null;
            goto L6
        }
    }

    static {
    }

    public abstract void a(Block r100, Map<String, Object> r101);

    public abstract void b(Context r100, AttributeSet r101);

    public void c() {
    }

    public AbsBlockView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        b(r100, null);
    }

    public AbsBlockView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        b(r100, r101);
    }

    public AbsBlockView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        b(r100, r101);
    }
}
