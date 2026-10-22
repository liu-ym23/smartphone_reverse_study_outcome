package y6b;

import com.bytedance.lark.pb.basic.v1.File;
import com.bytedance.lark.pb.basic.v1.Message;
import com.bytedance.lark.pb.basic.v1.MessageLink;
import com.larksuite.framework.utils.CollectionUtils;
import com.ss.android.lark.auditsdk.v2.receivecheck.entity.ValidateIMFileResult;
import com.ss.android.lark.chat.base.view.vo.message.BaseTextContentVO;
import com.ss.android.lark.chat.base.view.vo.message.CotDisplayModel;
import com.ss.android.lark.chat.base.view.vo.message.FileContentVO;
import com.ss.android.lark.chat.base.view.vo.message.ImageContentVO;
import com.ss.android.lark.chat.base.view.vo.message.MediaContentVO;
import com.ss.android.lark.chat.entity.message.AIInfo;
import com.ss.android.lark.chat.entity.message.CotContent;
import com.ss.android.lark.chat.entity.message.CotEvent;
import com.ss.android.lark.chat.entity.message.MessageDLPState;
import com.ss.android.lark.chat.entity.message.MessageEditInfo;
import com.ss.android.lark.chat.entity.message.MessageFoldDetail;
import com.ss.android.lark.chat.entity.message.MessageSecurityESCReviewExtra;
import com.ss.android.lark.chat.entity.message.MessageSenderAppInfo;
import com.ss.android.lark.chat.entity.message.MessageSourceDisplayPolicy;
import com.ss.android.lark.chat.entity.message.MessageStreamStatus;
import com.ss.android.lark.chat.entity.message.Pin;
import com.ss.android.lark.chat.entity.message.SendStatus;
import com.ss.android.lark.chat.entity.reaction.ReactionInfo;
import com.ss.android.lark.widget.richtext.i;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import v5b.a;

/* JADX INFO: loaded from: classes35.dex */
public abstract class a<T extends v5b.a<?>> implements v5b.c<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public CotContent f566422a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public CotDisplayModel f566423b;

    /* JADX INFO: renamed from: y6b.a$a, reason: collision with other inner class name */
    public static abstract class AbstractC8309a<C extends v5b.a<?>, T extends a<C>, B extends AbstractC8309a<C, ? extends T, ? extends B>> {
        public boolean A;
        public boolean B;
        public ValidateIMFileResult C;
        public Map<Integer, Message.DisabledAction.Behavior> D;
        public MessageStreamStatus E;
        public long F;
        public boolean G;
        public com.ss.android.lark.chat.entity.message.Message.SourceType H;
        public String I;

        /* JADX INFO: renamed from: J, reason: collision with root package name */
        public String f566424J;
        public MessageSourceDisplayPolicy K;
        public MessageSenderAppInfo L;
        public AIInfo M;
        public Map<String, MessageLink> N;
        public CotContent O;
        public CotDisplayModel P;
        public Map<Class<?>, ? extends Object> Q;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f566425a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f566426b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public com.ss.android.lark.chat.entity.message.Message.Type f566427c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public String f566428d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public String f566429e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final String f566430f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public boolean f566431g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public boolean f566432h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public boolean f566433i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f566434j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public long f566435k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public int f566436l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public int f566437m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public boolean f566438n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public com.ss.android.lark.chat.entity.message.Message.Status f566439o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public SendStatus f566440p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public y6b.b f566441q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public List<? extends ReactionInfo> f566442r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public C f566443s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public Pin f566444t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        public boolean f566445u;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        public boolean f566446v;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        public String f566447w;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        public int f566448x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        public MessageDLPState f566449y;

        /* JADX INFO: renamed from: z, reason: collision with root package name */
        public MessageSecurityESCReviewExtra f566450z;

        public AbstractC8309a() {
            this.f566425a = "";
            this.f566426b = "";
            this.f566427c = com.ss.android.lark.chat.entity.message.Message.Type.UNKNOWN;
            this.f566428d = "";
            this.f566429e = "";
            this.f566430f = "";
            this.f566439o = com.ss.android.lark.chat.entity.message.Message.Status.NORMAL;
            this.f566440p = SendStatus.SUCCESS;
            this.f566447w = "";
            this.D = MapsKt.emptyMap();
            this.E = MessageStreamStatus.Unknown;
        }

        public final com.ss.android.lark.chat.entity.message.Message.Type getType() {
            return this.f566427c;
        }

        public final void a(String r100) {
            Intrinsics.checkNotNullParameter(r100, "cId");
            this.f566426b = r100;
            Intrinsics.checkNotNull(this, "null cannot be cast to non-null type B of com.ss.android.lark.chat.vo.AbsMessageVO.Builder");
        }

        public final void b(String r100) {
            Intrinsics.checkNotNullParameter(r100, "chatId");
            this.f566428d = r100;
            Intrinsics.checkNotNull(this, "null cannot be cast to non-null type B of com.ss.android.lark.chat.vo.AbsMessageVO.Builder");
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final void c(v5b.a r100) {
            Intrinsics.checkNotNullParameter(r100, "contentVO");
            this.f566443s = r100;
            Intrinsics.checkNotNull(this, "null cannot be cast to non-null type B of com.ss.android.lark.chat.vo.AbsMessageVO.Builder");
        }

        public final void d(String r100) {
            Intrinsics.checkNotNullParameter(r100, "fromId");
            this.f566429e = r100;
            Intrinsics.checkNotNull(this, "null cannot be cast to non-null type B of com.ss.android.lark.chat.vo.AbsMessageVO.Builder");
        }

        public final void e(String r100) {
            Intrinsics.checkNotNullParameter(r100, "id");
            this.f566425a = r100;
            Intrinsics.checkNotNull(this, "null cannot be cast to non-null type B of com.ss.android.lark.chat.vo.AbsMessageVO.Builder");
        }

        public final void f(com.ss.android.lark.chat.entity.message.Message.Type r100) {
            Intrinsics.checkNotNullParameter(r100, "type");
            this.f566427c = r100;
            Intrinsics.checkNotNull(this, "null cannot be cast to non-null type B of com.ss.android.lark.chat.vo.AbsMessageVO.Builder");
        }
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f566451a = null;

        static {
            int[] r100 = new int[com.ss.android.lark.chat.entity.message.Message.Type.values().length];
            r100[com.ss.android.lark.chat.entity.message.Message.Type.IMAGE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L12
        L21:
            r100[com.ss.android.lark.chat.entity.message.Message.Type.MEDIA.ordinal()] = 2;     // Catch: NoSuchFieldError -> L13
        L31:
            r100[com.ss.android.lark.chat.entity.message.Message.Type.FILE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L14
        L23:
            r100[com.ss.android.lark.chat.entity.message.Message.Type.FOLDER.ordinal()] = 4;     // Catch: NoSuchFieldError -> L15
        L25:
            r100[com.ss.android.lark.chat.entity.message.Message.Type.MERGE_FORWARD.ordinal()] = 5;     // Catch: NoSuchFieldError -> L16
        L19:
            r100[com.ss.android.lark.chat.entity.message.Message.Type.TEXT.ordinal()] = 6;     // Catch: NoSuchFieldError -> L17
        L27:
            r100[com.ss.android.lark.chat.entity.message.Message.Type.POST.ordinal()] = 7;     // Catch: NoSuchFieldError -> L18
        L10:
            f566451a = r100;
        }
    }

    public a() {
    }

    public abstract int A();

    public abstract List<ReactionInfo> B();

    public abstract int C();

    public abstract y6b.b D();

    public abstract com.ss.android.lark.chat.entity.message.Message.RecallerIdentity E();

    public abstract String F();

    public abstract SendStatus G();

    public abstract boolean H();

    public abstract String I();

    public abstract com.ss.android.lark.chat.entity.message.Message.SourceType J();

    public abstract com.ss.android.lark.chat.entity.message.Message.Status K();

    public abstract MessageStreamStatus L();

    public abstract String M();

    public abstract ValidateIMFileResult N();

    public abstract boolean O();

    public abstract boolean P();

    public abstract boolean R();

    public abstract boolean S();

    public abstract boolean U();

    public abstract boolean V(long r100);

    @Override // v5b.c, v5b.d
    public abstract com.ss.android.lark.chat.entity.message.Message.Type getType();

    public abstract long o();

    public abstract int q();

    public abstract int r();

    public abstract MessageDLPState t();

    public abstract MessageEditInfo u();

    public abstract MessageSecurityESCReviewExtra v();

    public abstract Map<Class<?>, Object> w();

    public abstract MessageFoldDetail x();

    public abstract String y();

    public abstract Map<String, MessageLink> z();

    public final String s() {
        CotContent r100 = this.f566422a;
        Integer r101 = null;
        if (r100 != null) goto L5;
        return null;
    L5:
        CotEvent r102 = (CotEvent) CollectionsKt.lastOrNull(r100.getEvents());
        StringBuilder r103 = new StringBuilder();
        r103.append(r100.getCotId());
        r103.append('|');
        r103.append(r100.getEvents().size());
        r103.append('|');
        r103.append(r100.getStatus());
        r103.append('|');
        r103.append(r100.getViolated());
        r103.append('|');
        r103.append(r100.getCotEventsIncomplete());
        r103.append('|');
        if (r102 == null) goto L8;
        String r104 = r102.getEventId();
    L9:
        r103.append(r104);
        r103.append('|');
        if (r102 == null) goto L12;
        Long r105 = Long.valueOf(r102.getTimestamp());
    L13:
        r103.append(r105);
        r103.append('|');
        if (r102 == null) goto L18;
        String r106 = r102.getContent();
        if (r106 == null) goto L18;
        r101 = Integer.valueOf(r106.hashCode());
    L18:
        r103.append(r101);
        return r103.toString();
    L12:
        r105 = null;
        goto L13
    L8:
        r104 = null;
        goto L9
    }

    public final int hashCode() {
        String r100 = getId();
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = getChatId();
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = getcId();
        if (r107 == null) goto L14;
        r101 = r107.hashCode();
    L14:
        return r106 + r101;
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    @Override // v5b.c
    public final boolean isPreMessage() {
        return Intrinsics.areEqual(getId(), getcId());
    }

    @Override // v5b.c
    public final boolean l() {
        if (CollectionUtils.isEmpty(B()) == false) goto L5;
        return false;
    L5:
        List<ReactionInfo> r100 = B();
        Intrinsics.checkNotNull(r100);
        Iterator<ReactionInfo> r101 = r100.iterator();
    L7:
        if (r101.hasNext() == false) goto L12;
        if (r101.next().getReaction().getCount() <= 0) goto L7;
        return true;
    L12:
        return false;
    }

    public final List<String> p() {
        T r100 = b();
        if ((r100 instanceof FileContentVO) == false) goto L6;
        List r101 = CollectionsKt.listOfNotNull(((FileContentVO) r100).e());
    L24:
        ArrayList r102 = new ArrayList();
        Iterator r103 = r101.iterator();
    L26:
        if (r103.hasNext() == false) goto L30;
        Object r104 = r103.next();
        if ((!StringsKt.isBlank((String) r104)) == false) goto L26;
        r102.add(r104);
        goto L26
    L30:
        return r102;
    L6:
        if ((r100 instanceof ImageContentVO) == false) goto L9;
        r101 = CollectionsKt.listOfNotNull((String) ((ImageContentVO) r100).f411903j.getValue());
        goto L24
    L9:
        if ((r100 instanceof MediaContentVO) == false) goto L12;
        r101 = CollectionsKt.listOfNotNull((String) ((MediaContentVO) r100).f411912b.getValue());
        goto L24
    L12:
        if ((r100 instanceof com.ss.android.lark.chat.base.view.vo.message.a) == false) goto L15;
        r101 = CollectionsKt.listOfNotNull(((com.ss.android.lark.chat.base.view.vo.message.a) r100).e());
        goto L24
    L15:
        if ((r100 instanceof BaseTextContentVO) == false) goto L23;
        BaseTextContentVO r105 = (BaseTextContentVO) r100;
        List<String> r106 = i.k(r105.g());
        ArrayList<File> r107 = r105.f();
        ArrayList r108 = new ArrayList();
        Iterator<T> r109 = r107.iterator();
    L18:
        if (r109.hasNext() == false) goto L22;
        String r110 = ((File) r109.next()).key;
        if (r110 == null) goto L18;
        r108.add(r110);
        goto L18
    L22:
        r101 = CollectionsKt.plus(r106, r108);
        goto L24
    L23:
        r101 = CollectionsKt.emptyList();
        goto L24
    }

    public final boolean Q(a<?> r100) {
        if (r100 != null) goto L4;
    L8:
        return false;
    L4:
        if (Intrinsics.areEqual(this, r100) == false) goto L6;
    L7:
        return true;
    L6:
        if (Intrinsics.areEqual(getcId(), r100.getcId()) == false) goto L8;
        goto L7
    }

    @Override // v5b.c
    public final <T> T n(Class<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "clz");
        Map<Class<?>, Object> r101 = w();
        if (r101 == null) goto L8;
        T r102 = (T) r101.get(r100);
        if (r102 == null) goto L10;
        return r102;
    L10:
        return null;
    L8:
        return null;
    }

    public final boolean T(Map<Integer, Message.DisabledAction.Behavior> r100, Map<Integer, Message.DisabledAction.Behavior> r101) {
        Intrinsics.checkNotNullParameter(r100, "action1");
        Intrinsics.checkNotNullParameter(r101, "action2");
        if (r100.size() == r101.size()) goto L5;
        return false;
    L5:
        Iterator<Map.Entry<Integer, Message.DisabledAction.Behavior>> r102 = r100.entrySet().iterator();
    L7:
        if (r102.hasNext() == false) goto L15;
        Map.Entry<Integer, Message.DisabledAction.Behavior> r103 = r102.next();
        int r104 = r103.getKey().intValue();
        Message.DisabledAction.Behavior r105 = r103.getValue();
        Message.DisabledAction.Behavior r106 = r101.get(Integer.valueOf(r104));
        if (r106 == null) goto L14;
        if (r105.display_mode != r106.display_mode) goto L14;
        if (Intrinsics.areEqual(r105.code, r106.code) == true) goto L7;
    L14:
        return false;
    L15:
        return true;
    }
}
