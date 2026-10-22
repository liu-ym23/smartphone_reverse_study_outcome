package zib;

import com.baidu.platform.comapi.map.MapController;
import com.larksuite.framework.thread.CoreThreadPool;
import com.larksuite.framework.utils.CollectionUtils;
import com.ss.android.lark.chat.entity.chatter.Chatter;
import com.ss.android.lark.chat.utils.ChatParamUtils;
import com.ss.android.lark.dynamicconfig.interfaces.IDomainConfigService;
import com.ss.android.lark.forwardv3.data.ForwardTargetBaseInfoNew;
import com.ss.android.lark.search.dto.Source;
import com.ss.android.lark.search.dto.info.SearchAiKnowledgeInfo;
import com.ss.android.lark.search.dto.info.SearchBaseInfo;
import com.ss.android.lark.search.dto.info.SearchChatInfo;
import com.ss.android.lark.search.dto.info.SearchChatterInfo;
import com.ss.android.lark.statistics.Statistics;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import z5c.b3;
import z5c.c3;
import z5c.d3;
import z5c.e3;

/* JADX INFO: loaded from: classes36.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f572329a = 0;

    public static final class a {

        /* JADX INFO: renamed from: zib.e$a$a, reason: collision with other inner class name */
        public /* synthetic */ class C8466a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f572330a = null;

            static {
                int[] r100 = new int[Source.Type.values().length];
                r100[Source.Type.SEARCH.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
            L11:
                r100[Source.Type.FORWARD.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
            L15:
                r100[Source.Type.RECOMMEND.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
            L6:
                f572330a = r100;
            }
        }

        @JvmStatic
        public static String a(SearchBaseInfo r100) {
            Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
            if ((r100 instanceof SearchChatInfo) == false) goto L6;
            return "group";
        L6:
            if ((r100 instanceof SearchChatterInfo) == false) goto L12;
            if (((SearchChatterInfo) r100).getChatterType() != Chatter.ChatterType.BOT) goto L10;
            return "bot";
        L10:
            return "user";
        L12:
            if ((r100 instanceof SearchAiKnowledgeInfo) == false) goto L14;
            return IDomainConfigService.DomainAlias.KNOWLEDGE_AI;
        L14:
            return "other";
        }

        @JvmStatic
        public static void c(s5c.d r100) {
            Intrinsics.checkNotNullParameter(r100, "param");
            Statistics.sendEvent("im_msg_forward_select_click", r100.plus(ChatParamUtils.e()).toJson());
        }

        @JvmStatic
        public static void e(s5c.d r100) {
            Intrinsics.checkNotNullParameter(r100, "param");
            Statistics.sendEvent("im_msg_send_confirm_click", r100.plus(ChatParamUtils.e()).toJson());
        }

        public static void b(List r100, List r101) {
            Intrinsics.checkNotNullParameter(r101, "targets");
            if (CollectionUtils.isEmpty(r101) == false) goto L5;
            return;
        L5:
            if (CollectionUtils.isEmpty(r100) == true) goto L16;
            b.a r102 = new b.a();
            r102.f572334a = r100;
            Intrinsics.checkNotNullParameter(r101, "targets");
            r102.f572335b = r101;
            b r103 = new b(r102.f572334a, r101);
            if (CollectionUtils.isEmpty(r103.f572332b) == false) goto L10;
            return;
        L10:
            if (CollectionUtils.isEmpty(r103.f572333c) == true) goto L17;
            CoreThreadPool.getDefault().getFixedThreadPool().execute(new k(r103));
            return;
        L17:
            return;
        }

        @JvmStatic
        public static void d(s5c.a r100, boolean r101, long r102) {
            Intrinsics.checkNotNullParameter(r100, "version");
            CoreThreadPool.getDefault().getCachedThreadPool().execute(new i(r101, r102, r100));
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f572331a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final List<String> f572332b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final List<ForwardTargetBaseInfoNew> f572333c;

        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public List<String> f572334a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public List<? extends ForwardTargetBaseInfoNew> f572335b;

            public a() {
                this.f572334a = new ArrayList();
                this.f572335b = new ArrayList();
            }
        }

        public b(List r100, List r101) {
            Intrinsics.checkNotNullParameter(r101, "targets");
            this.f572331a = null;
            this.f572332b = r100;
            this.f572333c = r101;
        }
    }

    static {
    }

    @JvmStatic
    public static final s5c.d a(List<? extends SearchBaseInfo> r100) {
        Intrinsics.checkNotNullParameter(r100, "infos");
        Iterator<T> r101 = r100.iterator();
        int r102 = 0;
        int r103 = 0;
        int r104 = 0;
        int r105 = 0;
    L4:
        if (r101.hasNext() == false) goto L16;
        SearchBaseInfo r106 = (SearchBaseInfo) r101.next();
        if ((r106 instanceof SearchChatInfo) == true) goto L8;
        if ((r106 instanceof SearchChatterInfo) == false) goto L4;
        r103 = r103 + 1;
        if (((SearchChatterInfo) r106).getChatterType() != Chatter.ChatterType.BOT) goto L4;
        r105 = r105 + 1;
        goto L4
    L8:
        if (((SearchChatInfo) r106).isSecretChat() == false) goto L10;
        r102 = r102 + 1;
    L10:
        r104 = r104 + 1;
        goto L4
    L16:
        s5c.a r107 = c3.f570177c.a(String.valueOf(r102));
        s5c.a r108 = e3.f570192c.a(String.valueOf(r103));
        s5c.a r109 = d3.f570184c.a(String.valueOf(r104));
        return s5c.d.b.b(b3.f570159c.a(String.valueOf(r105)), r107).plus(r108).plus(r109);
    }
}
