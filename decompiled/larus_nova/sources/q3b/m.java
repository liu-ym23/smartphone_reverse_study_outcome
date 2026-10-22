package q3b;

import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.framework.utils.CollectionUtils;
import com.ss.android.lark.biz.im.api.a1;
import com.ss.android.lark.biz.im.api.w0;
import com.ss.android.lark.chat.chatwindow.chat.model.pin.MessageListPinExtraLoader;
import com.ss.android.lark.chat.chatwindow.chat.v2.push.v;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.MessageFoldDetail;
import com.ss.android.lark.chat.entity.message.MessageInfo;
import com.ss.android.lark.chatbase.BasePageStore;
import com.ss.android.lark.log.Log;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes35.dex */
public final class m extends BasePageStore<MessageInfo, x4b.a<MessageInfo>> {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Map<String, Boolean> f531573k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final List<Pair<Integer, Integer>> f531574l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public c f531575m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final com.ss.android.lark.chat.chatwindow.chat.data.convert.textprocess.a f531576n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final MessageListPinExtraLoader f531577o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final a2b.j.a f531578p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final boolean f531579q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f531580r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public w0 f531581s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public a1 f531582t;

    public class a implements r3b.a.InterfaceC7430a<MessageInfo> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ m f531583a;

        public a(m r100) {
            this.f531583a = r100;
        }
    }

    public class b implements com.ss.android.lark.chatbase.j<MessageInfo> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ m f531584a;

        @Override // com.ss.android.lark.chatbase.j
        public final void c(List<MessageInfo> r100) {
        }

        public b(m r100) {
            this.f531584a = r100;
        }

        @Override // com.ss.android.lark.chatbase.j
        public final /* bridge */ /* synthetic */ void a(f5b.b r100) {
            MessageInfo r101 = (MessageInfo) r100;
        }

        @Override // com.ss.android.lark.chatbase.j
        public final void b(List<MessageInfo> r100, x4b.a<MessageInfo> r101) {
            if ((r101 instanceof e) == false) goto L11;
            m r102 = this.f531584a;
            e r103 = (e) r101;
            r102.getClass();
            if (r103 == null) goto L9;
            int r104 = r103.f531563d;
            if (r104 <= 0) goto L9;
            r102.f531580r = r104;
        L9:
            Map<String, Boolean> r105 = this.f531584a.f531573k;
            ConcurrentHashMap r106 = (ConcurrentHashMap) r105;
            r106.putAll(r103.f531564e);
            return;
        }
    }

    public interface c {
        int a();
    }

    @Override // com.ss.android.lark.chatbase.BasePageStore
    public final String x() {
        return "ChatWindowDataStore";
    }

    /* JADX WARN: Type inference failed for: r1v3, types: [q3b.f] */
    /* JADX WARN: Type inference failed for: r1v4, types: [q3b.g] */
    /* JADX WARN: Type inference failed for: r2v0, types: [q3b.h] */
    @Override // com.ss.android.lark.chatbase.BasePageStore
    public final void J() {
        h(new com.ss.android.lark.chat.chatwindow.chat.model.data.decorator.d(this.f416848g));
        h(new com.ss.android.lark.chat.chatwindow.chat.model.data.decorator.b(this.f416848g.E()));
        h(new com.ss.android.lark.chat.chatwindow.chat.model.data.decorator.f(new f(this)));
        h(new com.ss.android.lark.chat.chatwindow.chat.model.data.decorator.c());
        h(new com.ss.android.lark.chat.chatwindow.chat.model.data.decorator.e(new g(this)));
        h(new com.ss.android.lark.chat.chatwindow.chat.model.data.decorator.a(this.f416848g, new h(this)));
    }

    @Override // com.ss.android.lark.chatbase.BasePageStore
    public final void K() {
        i(new r3b.b(this.f416848g.P()));
        i(new r3b.a(new a(this)));
        i(new b(this));
    }

    public final void V() {
        int r100 = this.f416843b.size();
        if (r100 >= 30) goto L6;
        Log.i("ChatWindowDataStore", "current item size is:" + r100 + ", no need opt");
        return;
    L6:
        this.f416890a.execute(new j(this));
    }

    @Override // com.ss.android.lark.chatbase.BasePageStore
    public final void I() {
        super.I();
        ((ArrayList) this.f531574l).clear();
    }

    @Override // com.ss.android.lark.chatbase.BasePageStore
    public final boolean D() {
        return this.f531579q;
    }

    @Override // com.ss.android.lark.chatbase.BasePageStore
    public final boolean C(f5b.b r100) {
        MessageInfo r101 = (MessageInfo) r100;
        if (this.f531579q == false) goto L8;
        if (r101.getMessageFoldDetail() == null) goto L8;
        return !r101.getMessageFoldDetail().isFakeFold();
    L8:
        return super.C(r101);
    }

    @Override // com.ss.android.lark.chatbase.BasePageStore
    public final boolean E(f5b.b r110) {
        MessageInfo r111 = (MessageInfo) r110;
        boolean r100 = true;
        if (this.f531579q == false) goto L37;
        List<Pair<Integer, Integer>> r101 = this.f531574l;
        String r102 = r111.getMessage().getFoldId();
        if (TextUtils.isEmpty(r102) == false) goto L7;
    L9:
        boolean r103 = false;
    L11:
        if (r111.isPreMessage() == false) goto L13;
    L17:
        boolean r104 = true;
    L19:
        if (r104 == true) goto L28;
        int r105 = r111.getMessage().getPosition();
        Iterator r106 = ((ArrayList) r101).iterator();
    L22:
        if (r106.hasNext() == false) goto L28;
        Pair r107 = (Pair) r106.next();
        if (((Integer) r107.first).intValue() > r105) goto L22;
        if (((Integer) r107.second).intValue() < r105) goto L22;
        Log.d("MessageUtils", "isMessageFilterByFold: msg position:" + r105 + " is in fold interval [" + r107.first + " , " + r107.second + "]");
        boolean r108 = true;
    L29:
        boolean r109 = !TextUtils.isEmpty(r102);
        Log.d("MessageUtils", "isMessageFilterByFold: msgHasFoldId: " + r109 + " , inFoldInterval: " + r108 + " , skipFold: " + r104);
        if (r109 == true) goto L32;
        if (r108 == true) goto L32;
    L34:
        boolean r112 = false;
    L35:
        if (r112 == false) goto L37;
        boolean r113 = true;
    L38:
        Log.d("ChatWindowDataStore", "msg id " + r111.getMessage().getId() + " , pos: " + U(r111) + " foldId: " + r111.getMessage().getFoldId() + " fold: " + r111.getMessageFoldDetail());
        if (r113 == false) goto L53;
        Log.i("ChatWindowDataStore", "isValidData: current message should be fold , return false, msg id " + r111.getMessage().getId() + " , pos " + U(r111));
        Message r114 = r111.getMessage();
        String r115 = r114.getcId();
        if (TextUtils.isEmpty(r115) == false) goto L43;
        Log.w("ChatWindowDataStore", "tryRemoveFakeMessageInDatas: message cid is empty, " + r114.getId());
        return false;
    L43:
        Iterator r116 = this.f416843b.iterator();
    L45:
        if (r116.hasNext() == false) goto L49;
        final MessageInfo r117 = (MessageInfo) r116.next();
        if (Objects.equals(r117.getMessage().getcId(), r115) == false) goto L45;
    L50:
        if (r117 == null) goto L72;
        Log.i("ChatWindowDataStore", "tryRemoveFakeMessageInDatas: find preMessage in mDatas, cid: " + r115);
        this.f416890a.execute(new i(this, r117));
        return false;
    L72:
        return false;
    L49:
        r117 = null;
        goto L50
    L53:
        if (this.f531581s.a() == Integer.MIN_VALUE) goto L55;
        int r118 = this.f531581s.a();
    L57:
        if (U(r111) >= r118) goto L61;
        r100 = false;
    L61:
        return r100;
    L55:
        r118 = -1;
    L32:
        if (r104 == true) goto L34;
        r112 = true;
    L28:
        r108 = false;
        goto L29
    L13:
        if (r111.getMessageFoldDetail() != null) goto L17;
        if (r103 == true) goto L17;
        r104 = false;
        goto L19
    L7:
        if (r102.equals(r111.getId()) == false) goto L9;
        r103 = true;
    L37:
        r113 = false;
        goto L38
    }

    @Override // com.ss.android.lark.chatbase.BasePageStore
    public final void G(x4b.a<MessageInfo> r100) {
        super.G(r100);
        if ((r100 instanceof e) == false) goto L6;
        Map<String, Boolean> r101 = this.f531573k;
        ConcurrentHashMap r102 = (ConcurrentHashMap) r101;
        r102.putAll(((e) r100).f531564e);
        return;
    }

    @Override // com.ss.android.lark.chatbase.BasePageStore
    public final void L(w0 r100) {
        this.f531581s = r100;
    }

    @Override // com.ss.android.lark.chatbase.BasePageStore
    public final void M(a1 r100) {
        this.f531582t = r100;
    }

    public final int U(MessageInfo r100) {
        return this.f531582t.a(r100);
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // com.ss.android.lark.chatbase.BasePageStore
    public final void j(f5b.b r100) {
        MessageInfo r101 = (MessageInfo) r100;
        int r102 = U(r101);
        if (r101.isPreMessage() == false) goto L5;
    L17:
        super.j(r101);
        return;
    L5:
        if (this.f416843b.size() == 0) goto L17;
        if (r102 > this.f416845d) goto L17;
        int r103 = 0;
    L11:
        if (r103 >= this.f416843b.size()) goto L16;
        int r104 = U((MessageInfo) this.f416843b.get(r103));
        if (r104 > r102) goto L14;
        r103 = r103 + 1;
        goto L11
    L14:
        Log.i("ChatWindowDataStore", "appendNewItem into position:" + r103 + ", newItemPosition is" + r102 + ", nextPosition is:" + r104);
        this.f416843b.add(r103, r101);
        return;
    L16:
        Log.w("ChatWindowDataStore", "appendNewItem, can't find insert position, append to last position");
        super.j(r101);
    }

    @Override // com.ss.android.lark.chatbase.BasePageStore
    public final boolean n(f5b.b r100) {
        MessageInfo r101 = (MessageInfo) r100;
        StringBuilder r102 = new StringBuilder("canAppendNewItem: pos is ");
        r102.append(U(r101));
        r102.append(" , item id is: ");
        r102.append(r101.getMessage().getId());
        r102.append(" , item has fold: ");
        if (r101.getMessageFoldDetail() == null) goto L5;
        boolean r103 = true;
    L6:
        r102.append(r103);
        Log.d("ChatWindowDataStore", r102.toString());
        if (r101.isPreMessage() == true) goto L9;
        int r104 = U(r101);
        MessageFoldDetail r105 = r101.getMessageFoldDetail();
        if (this.f531579q == false) goto L15;
        if (r105 == null) goto L15;
        int r106 = (int) Math.max(r105.getLastMessagePosition(), r104);
    L17:
        if (this.f416844c != Integer.MAX_VALUE) goto L25;
        if (this.f416845d != Integer.MIN_VALUE) goto L25;
        int r107 = this.f416847f.get();
        Log.d("ChatWindowDataStore", "canAppendNewItem: lastPos is " + r107 + " , position is " + r104);
        if (r107 < r104) goto L47;
        if (r107 < r106) goto L47;
        return false;
    L47:
        return true;
    L25:
        if (r106 < this.f416844c) goto L30;
        if (r106 <= this.f416845d) goto L47;
    L30:
        if (r104 >= this.f416844c) goto L33;
        return false;
    L33:
        if (r104 > (this.f416845d + 1)) goto L52;
        c r108 = this.f531575m;
        if (r108 == null) goto L44;
        int r109 = r108.a();
        if (r109 < 0) goto L44;
        Log.i("ChatWindowDataStore", "newItemPosition is:" + r104 + ", lastItemPosition is:" + r109);
        if ((r104 - r109) <= 100) goto L44;
        boolean r110 = true;
    L45:
        if (r110 == false) goto L47;
        return false;
    L44:
        r110 = false;
        goto L45
    L52:
        return false;
    L15:
        r106 = r104;
        goto L17
    L9:
        if (B(r101) == false) goto L47;
        return false;
    L5:
        r103 = false;
        goto L6
    }

    @Override // com.ss.android.lark.chatbase.BasePageStore
    public final void q(f5b.b r110) {
        MessageInfo r111 = (MessageInfo) r110;
        if (this.f531579q == true) goto L5;
        r111.setMessageFoldDetail(null);
    L5:
        super.q(r111);
        if (this.f531579q == true) goto L8;
        return;
    L8:
        if (r111.getMessageFoldDetail() != null) goto L10;
        return;
    L10:
        if (this.f531579q == true) goto L12;
        return;
    L12:
        if (r111.getMessageFoldDetail() == null) goto L76;
        MessageFoldDetail r112 = r111.getMessageFoldDetail();
        int r100 = (int) r112.getRootMessagePosition();
        int r113 = (int) r112.getLastMessagePosition();
        if (r100 < 0) goto L75;
        if (r113 < 0) goto L77;
        ArrayList r101 = new ArrayList(this.f531574l);
        r101.add(new Pair(Integer.valueOf(r100), Integer.valueOf(r113)));
        Collections.sort(r101, new k());
        ArrayList r114 = new ArrayList(r101.size());
        int r102 = ((Integer) ((Pair) ListProtector.get(r101, 0)).first).intValue();
        int r103 = ((Integer) ((Pair) ListProtector.get(r101, 0)).second).intValue();
        int r104 = 1;
    L20:
        if (r104 >= r101.size()) goto L26;
        Pair r105 = (Pair) ListProtector.get(r101, r104);
        if (((Integer) r105.first).intValue() <= r103) goto L24;
        r114.add(new Pair(Integer.valueOf(r102), Integer.valueOf(r103)));
        r102 = ((Integer) r105.first).intValue();
        r103 = ((Integer) r105.second).intValue();
    L25:
        r104 = r104 + 1;
        goto L20
    L24:
        r103 = Math.max(r103, ((Integer) r105.second).intValue());
        goto L25
    L26:
        r114.add(new Pair(Integer.valueOf(r102), Integer.valueOf(r103)));
        CollectionUtils.resetToList(this.f531574l, r114);
        Log.d("ChatWindowDataStore", "updateFoldIntervalIfNeed: foldIntervals: " + this.f531574l);
        final ArrayList r115 = new ArrayList();
        ArrayList r106 = new ArrayList();
        Iterator r107 = this.f416843b.iterator();
    L28:
        if (r107.hasNext() == false) goto L50;
        MessageInfo r108 = (MessageInfo) r107.next();
        String r109 = r108.getMessage().getFoldId();
        if (TextUtils.isEmpty(r109) == false) goto L32;
    L34:
        boolean r116 = false;
    L36:
        if (r108.getMessageFoldDetail() != null) goto L28;
        if (r108.isPreMessage() == true) goto L28;
        if (r116 == true) goto L28;
        int r117 = U(r108);
        Iterator r118 = ((ArrayList) this.f531574l).iterator();
    L43:
        if (r118.hasNext() == false) goto L28;
        Pair r119 = (Pair) r118.next();
        if (r117 < ((Integer) r119.first).intValue()) goto L43;
        if (r117 > ((Integer) r119.second).intValue()) goto L43;
        r115.add(r108.getId());
        r106.add(Integer.valueOf(r117));
        goto L28
    L32:
        if (r109.equals(r108.getId()) == false) goto L34;
        r116 = true;
        goto L36
    L50:
        if (r115.isEmpty() == true) goto L78;
        Log.i("ChatWindowDataStore", "removeFoldMessagesInDataStoreIfNeed: find " + r115.size() + " messages to fold , remove positions: " + r106);
        this.f416890a.execute(new l(this, r115));
        return;
    L78:
        return;
    L77:
        return;
    L75:
        return;
    }

    @Override // com.ss.android.lark.chatbase.BasePageStore
    public final int t(f5b.b r100) {
        return ((MessageInfo) r100).getMessage().getBadgeCount();
    }

    @Override // com.ss.android.lark.chatbase.BasePageStore
    public final /* bridge */ /* synthetic */ int v(f5b.b r100) {
        return U((MessageInfo) r100);
    }

    public final boolean T(MessageInfo r100, MessageInfo r101) {
        if (this.f531579q == false) goto L16;
        long r102 = 0;
        if (r100.getMessageFoldDetail() == null) goto L7;
        long r103 = r100.getMessageFoldDetail().getUpdateTimeMs();
    L9:
        if (r101.getMessageFoldDetail() == null) goto L12;
        r102 = r101.getMessageFoldDetail().getUpdateTimeMs();
    L12:
        if (r102 <= r103) goto L16;
        return true;
    L7:
        r103 = 0;
    L16:
        return super.o(r100, r101);
    }

    @Override // com.ss.android.lark.chatbase.BasePageStore
    public final /* bridge */ /* synthetic */ boolean o(f5b.b r100, f5b.b r101) {
        return T((MessageInfo) r100, (MessageInfo) r101);
    }

    public m(v r100, x4b.d r101, BasePageStore.c r102, com.ss.android.lark.chat.chatwindow.chat.data.convert.textprocess.a r103, MessageListPinExtraLoader r104, a2b.j.a r105, boolean r106) {
        super(r100, r101, r102);
        this.f531574l = new ArrayList();
        this.f531580r = 0;
        this.f531581s = w0.f410442a;
        this.f531582t = a1.a.f409900a;
        this.f531573k = new ConcurrentHashMap();
        this.f531576n = r103;
        this.f531577o = r104;
        this.f531578p = r105;
        this.f531579q = r106;
    }
}
