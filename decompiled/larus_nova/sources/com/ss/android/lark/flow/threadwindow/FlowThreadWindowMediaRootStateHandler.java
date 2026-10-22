package com.ss.android.lark.flow.threadwindow;

import android.os.Handler;
import android.os.Looper;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.ss.android.lark.biz.im.api.ThreadTopic;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.SendStatus;
import com.ss.android.lark.chat.entity.message.content.MediaContent;
import com.ss.android.lark.utils.UIHelper;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IndexedValue;
import kotlin.collections.IntIterator;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class FlowThreadWindowMediaRootStateHandler {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ int f424182h = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f424183a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Handler f424184b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<n5b.a> f424185c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<String, Message> f424186d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final MutableLiveData<String> f424187e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Function0<Boolean> f424188f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Function0<Unit> f424189g;

    public static final class a {
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ FlowThreadWindowMediaRootStateHandler f424190a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Message f424191b;

        public b(FlowThreadWindowMediaRootStateHandler r100, Message r101) {
            this.f424190a = r100;
            this.f424191b = r101;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f424190a.g(this.f424191b);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ FlowThreadWindowMediaRootStateHandler f424192a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Message f424193b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f424194c;

        public c(FlowThreadWindowMediaRootStateHandler r100, Message r101, String r102) {
            this.f424192a = r100;
            this.f424193b = r101;
            this.f424194c = r102;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f424192a.h(this.f424193b, this.f424194c);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
    }

    public static Integer l(Integer r100) {
        if (r100 == null) goto L11;
        int r101 = r100.intValue();
        if (r101 > 0) goto L6;
    L8:
        boolean r102 = false;
    L9:
        if (r102 == false) goto L11;
        return r100;
    L6:
        if (r101 == Integer.MAX_VALUE) goto L8;
        r102 = true;
    L11:
        return null;
    }

    public final int d(Message r100) {
        if (r100.getType() == Message.Type.MEDIA) goto L5;
        return -1;
    L5:
        Iterator<n5b.a> r101 = this.f424185c.iterator();
        int r102 = 0;
    L7:
        if (r101.hasNext() == false) goto L26;
        n5b.a r103 = r101.next();
        Message r104 = r103.f518078c;
        if (r104 != null) goto L11;
    L19:
        boolean r105 = false;
    L20:
        if (r105 == true) goto L23;
        r102 = r102 + 1;
        goto L7
    L23:
        return r102;
    L11:
        if (r104.isPreMessage() == false) goto L19;
        if (r104.getType() != Message.Type.MEDIA) goto L19;
        if (n.a(r104) == false) goto L19;
        if (j(r103, r100) == false) goto L19;
        r105 = true;
        goto L20
    L26:
        return -1;
    }

    public final void f(ErrorResult r100) {
        String r101 = r100.getDisplayMsg(UIHelper.getString(R.string.Lark_Legacy_ErrorMessageTip));
        if (r101 != null) goto L5;
        return;
    L5:
        if (r101.length() <= 0) goto L7;
        boolean r102 = true;
    L8:
        if (r102 == true) goto L11;
        r101 = null;
    L11:
        if (r101 == null) goto L15;
        this.f424187e.postValue(r101);
        return;
    L15:
        return;
    L7:
        r102 = false;
        goto L8
    }

    public final void g(Message r100) {
        Intrinsics.checkNotNullParameter(r100, "preMessage");
        if (this.f424188f.invoke().booleanValue() == false) goto L5;
        return;
    L5:
        if (r100.getType() == Message.Type.MEDIA) goto L7;
        return;
    L7:
        if (n.a(r100) == true) goto L10;
        return;
    L10:
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == true) goto L13;
        this.f424184b.post(new b(this, r100));
        return;
    L13:
        String r101 = r100.getcId();
        if (r101 != null) goto L16;
    L21:
        r101 = null;
    L22:
        int r102 = e(r100, r101);
        if (r102 >= 0) goto L25;
        return;
    L25:
        ((n5b.a) ListProtector.get(this.f424185c, r102)).f518078c = r100;
        this.f424189g.invoke();
        return;
    L16:
        if (r101.length() <= 0) goto L18;
        boolean r103 = true;
    L19:
        if (r103 == false) goto L21;
    L18:
        r103 = false;
        goto L19
    }

    public static final void b(FlowThreadWindowMediaRootStateHandler r100, Message r101) {
        r100.getClass();
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == true) goto L5;
        r100.f424184b.post(new l(r100, r101));
        return;
    L5:
        String r102 = r101.getcId();
        if (r102 != null) goto L8;
    L13:
        r102 = null;
    L14:
        int r103 = r100.e(r101, r102);
        if (r103 < 0) goto L20;
        ((n5b.a) ListProtector.get(r100.f424185c, r103)).f518078c = r101;
        r100.f424189g.invoke();
        return;
    L20:
        return;
    L8:
        if (r102.length() <= 0) goto L10;
        boolean r104 = true;
    L11:
        if (r104 == false) goto L13;
    L10:
        r104 = false;
        goto L11
    }

    public static boolean i(n5b.a r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "threadInfo");
        Intrinsics.checkNotNullParameter(r101, "key");
        Message r102 = r100.f518078c;
        String r103 = null;
        if (r102 != null) goto L5;
    L13:
        MediaContent r104 = null;
    L14:
        String r105 = n.b(r101);
        ThreadTopic r106 = r100.f518077b;
        if (r106 == null) goto L17;
        String r107 = r106.getId();
    L19:
        if (Intrinsics.areEqual(r107, r101) == true) goto L46;
        ThreadTopic r108 = r100.f518077b;
        if (r108 == null) goto L23;
        String r109 = r108.getRootMsgId();
    L25:
        if (Intrinsics.areEqual(r109, r101) == true) goto L46;
        if (r102 == null) goto L28;
        String r110 = r102.getId();
    L30:
        if (Intrinsics.areEqual(r110, r101) == true) goto L46;
        if (r102 == null) goto L33;
        String r111 = r102.getcId();
    L35:
        if (Intrinsics.areEqual(r111, r101) == true) goto L46;
        if (r105 == null) goto L48;
        if (r104 == null) goto L39;
        String r112 = r104.getMediaUploadId();
    L41:
        if (Intrinsics.areEqual(n.b(r112), r105) == true) goto L46;
        if (r104 == null) goto L45;
        r103 = r104.getFirstScreenImageUploadId();
    L45:
        if (Intrinsics.areEqual(n.b(r103), r105) == true) goto L46;
        return false;
    L39:
        r112 = null;
        goto L41
    L48:
        return false;
    L33:
        r111 = null;
        goto L35
    L28:
        r110 = null;
        goto L30
    L23:
        r109 = null;
    L46:
        return true;
    L17:
        r107 = null;
        goto L19
    L5:
        if (r102.getType() != Message.Type.MEDIA) goto L7;
        boolean r113 = true;
    L8:
        if (r113 == false) goto L10;
        Message r114 = r102;
    L11:
        if (r114 == null) goto L13;
        r104 = (MediaContent) r114.getContent();
        goto L14
    L10:
        r114 = null;
        goto L11
    L7:
        r113 = false;
        goto L8
    }

    public static boolean j(n5b.a r100, Message r101) {
        Intrinsics.checkNotNullParameter(r100, "threadInfo");
        Intrinsics.checkNotNullParameter(r101, "message");
        String r102 = r101.getcId();
        String r103 = null;
        if (r102 != null) goto L5;
    L10:
        r102 = null;
    L11:
        String r104 = r101.getId();
        if (r104 != null) goto L14;
    L19:
        r104 = null;
    L21:
        if (r101.getType() != Message.Type.MEDIA) goto L23;
        boolean r105 = true;
    L24:
        if (r105 == true) goto L27;
        r101 = null;
    L27:
        if (r101 == null) goto L29;
        MediaContent r106 = (MediaContent) r101.getContent();
    L30:
        String[] r107 = new String[4];
        r107[0] = r104;
        r107[1] = r102;
        if (r106 == null) goto L33;
        String r108 = r106.getMediaUploadId();
    L34:
        r107[2] = n.b(r108);
        if (r106 == null) goto L37;
        r103 = r106.getFirstScreenImageUploadId();
    L37:
        r107[3] = n.b(r103);
        List r109 = CollectionsKt.listOfNotNull(r107);
        if ((r109 instanceof Collection) == true) goto L40;
    L42:
        Iterator r110 = r109.iterator();
    L44:
        if (r110.hasNext() == false) goto L48;
        if (i(r100, (String) r110.next()) == false) goto L44;
        return true;
    L48:
        return false;
    L40:
        if (r109.isEmpty() == false) goto L42;
    L33:
        r108 = null;
        goto L34
    L29:
        r106 = null;
        goto L30
    L23:
        r105 = false;
        goto L24
    L14:
        if (r104.length() <= 0) goto L16;
        boolean r111 = true;
    L17:
        if (r111 == false) goto L19;
    L16:
        r111 = false;
        goto L17
    L5:
        if (r102.length() <= 0) goto L7;
        boolean r112 = true;
    L8:
        if (r112 == false) goto L10;
    L7:
        r112 = false;
        goto L8
    }

    public final int c(Message r110, ThreadTopic r111) {
        if (r110 == null) goto L174;
        if (r110.isPreMessage() == true) goto L174;
        if (r110.getType() != Message.Type.MEDIA) goto L174;
        Iterable r100 = CollectionsKt.withIndex(this.f424185c);
        ArrayList r101 = new ArrayList();
        Iterator r102 = r100.iterator();
    L10:
        boolean r103 = false;
        if (r102.hasNext() == false) goto L51;
        Object r104 = r102.next();
        Message r105 = ((n5b.a) ((IndexedValue) r104).component2()).f518078c;
        if (r105 != null) goto L16;
    L48:
        if (r103 == false) goto L10;
        r101.add(r104);
        goto L10
    L16:
        if (r105.isPreMessage() == false) goto L48;
        if (r105.getType() != Message.Type.MEDIA) goto L48;
        if (r105.isFromMe() == false) goto L48;
        if (r110.isFromMe() == false) goto L26;
    L29:
        boolean r106 = true;
    L30:
        if (r106 == false) goto L48;
        String r107 = r105.getRootId();
        if (r107 != null) goto L34;
    L37:
        boolean r108 = true;
    L38:
        if (r108 == false) goto L48;
        String r109 = r105.getParentId();
        if (r109 != null) goto L42;
    L45:
        boolean r112 = true;
    L46:
        if (r112 == false) goto L48;
        r103 = true;
        goto L48
    L42:
        if (r109.length() == 0) goto L45;
        r112 = false;
        goto L46
    L34:
        if (r107.length() == 0) goto L37;
        r108 = false;
        goto L38
    L26:
        if (Intrinsics.areEqual(r110.getFromId(), r105.getFromId()) == true) goto L29;
        r106 = false;
        goto L30
    L51:
        if (r101.isEmpty() == false) goto L53;
        return -1;
    L53:
        ArrayList r113 = new ArrayList();
        Iterator r114 = r101.iterator();
    L54:
        IndexedValue r115 = null;
        Integer r116 = null;
        if (r114.hasNext() == false) goto L167;
        Object r117 = r114.next();
        n5b.a r118 = (n5b.a) ((IndexedValue) r117).component2();
        Message r119 = r118.f518078c;
        if (r119 == null) goto L163;
        Message.Type r120 = r119.getType();
        Message.Type r121 = Message.Type.MEDIA;
        if (r120 != r121) goto L62;
        boolean r122 = true;
    L63:
        if (r122 == true) goto L66;
        r119 = null;
    L66:
        if (r119 == null) goto L163;
        MediaContent r123 = (MediaContent) r119.getContent();
        if (r123 == null) goto L163;
        if (r110.getType() != r121) goto L73;
        boolean r124 = true;
    L74:
        if (r124 == false) goto L76;
        Message r125 = r110;
    L77:
        if (r125 == null) goto L163;
        MediaContent r126 = (MediaContent) r125.getContent();
        if (r126 == null) goto L163;
        String r127 = r123.getMediaUploadId();
        String r128 = r126.getMediaUploadId();
        String r129 = n.b(r127);
        if (r129 != null) goto L84;
    L86:
        boolean r130 = false;
    L87:
        if (r130 == true) goto L97;
        String r131 = r123.getFirstScreenImageUploadId();
        String r132 = r126.getFirstScreenImageUploadId();
        String r133 = n.b(r131);
        if (r133 != null) goto L91;
    L93:
        boolean r134 = false;
    L94:
        if (r134 == true) goto L97;
        boolean r135 = false;
    L98:
        if (r135 == true) goto L162;
        if (r111 == null) goto L102;
        Integer r136 = Integer.valueOf(r111.getPosition());
    L103:
        Integer r137 = l(r136);
        if (r137 != null) goto L106;
        r137 = l(Integer.valueOf(r110.getThreadPosition()));
    L106:
        ThreadTopic r138 = r118.f518077b;
        if (r138 == null) goto L109;
        Integer r139 = Integer.valueOf(r138.getPosition());
    L110:
        Integer r140 = l(r139);
        if (r140 != null) goto L116;
        Message r141 = r118.f518078c;
        if (r141 == null) goto L115;
        r116 = Integer.valueOf(r141.getThreadPosition());
    L115:
        r140 = l(r116);
    L116:
        if (r137 != null) goto L118;
    L120:
        boolean r142 = false;
    L121:
        if (r142 == false) goto L163;
        if (r123.getSize() > 0) goto L125;
    L127:
        boolean r143 = false;
    L129:
        if (r123.getDuration() > 0) goto L131;
    L133:
        boolean r144 = false;
    L135:
        if (r123.getName().length() <= 0) goto L137;
        boolean r145 = true;
    L138:
        if (r145 == true) goto L140;
    L142:
        boolean r146 = false;
    L144:
        if (r123.getMime().length() <= 0) goto L146;
        boolean r147 = true;
    L147:
        if (r147 == true) goto L149;
    L151:
        boolean r148 = false;
    L152:
        if (r143 == false) goto L154;
        if (r144 == false) goto L154;
    L159:
        boolean r149 = true;
    L161:
        if (r149 == false) goto L163;
    L154:
        if (r143 == false) goto L156;
        if (r146 == true) goto L159;
    L156:
        if (r144 == false) goto L160;
        if (r146 == false) goto L160;
        if (r148 == true) goto L159;
    L160:
        r149 = false;
        goto L161
    L149:
        if (Intrinsics.areEqual(r123.getMime(), r126.getMime()) == false) goto L151;
        r148 = true;
        goto L152
    L146:
        r147 = false;
        goto L147
    L140:
        if (Intrinsics.areEqual(r123.getName(), r126.getName()) == false) goto L142;
        r146 = true;
        goto L144
    L137:
        r145 = false;
        goto L138
    L131:
        if (r123.getDuration() != r126.getDuration()) goto L133;
        r144 = true;
        goto L135
    L125:
        if (r123.getSize() != r126.getSize()) goto L127;
        r143 = true;
        goto L129
    L118:
        if (Intrinsics.areEqual(r137, r140) == false) goto L120;
        r142 = true;
        goto L121
    L109:
        r139 = null;
        goto L110
    L102:
        r136 = null;
    L162:
        boolean r150 = true;
    L164:
        if (r150 == false) goto L54;
        r113.add(r117);
        goto L54
    L91:
        if (Intrinsics.areEqual(r133, n.b(r132)) == false) goto L93;
        r134 = true;
    L97:
        r135 = true;
        goto L98
    L84:
        if (Intrinsics.areEqual(r129, n.b(r128)) == false) goto L86;
        r130 = true;
        goto L87
    L76:
        r125 = null;
        goto L77
    L73:
        r124 = false;
        goto L74
    L62:
        r122 = false;
    L163:
        r150 = false;
        goto L164
    L167:
        if (r113.size() != 1) goto L169;
        r115 = (IndexedValue) CollectionsKt.first(r113);
    L170:
        if (r115 != null) goto L185;
        return -1;
    L185:
        return r115.getIndex();
    L169:
        r113.size();
    L174:
        return -1;
    }

    public final int e(Message r100, String r101) {
        int r102 = 0;
        if (r101 == null) goto L11;
        Iterator<n5b.a> r103 = this.f424185c.iterator();
        int r104 = 0;
    L6:
        if (r103.hasNext() == false) goto L11;
        if (i(r103.next(), r101) == true) goto L12;
        r104 = r104 + 1;
    L12:
        if (r104 < 0) goto L14;
        return r104;
    L14:
        int r105 = d(r100);
        if (r105 < 0) goto L17;
        return r105;
    L17:
        Iterator<n5b.a> r106 = this.f424185c.iterator();
    L19:
        if (r106.hasNext() == false) goto L29;
        if (j(r106.next(), r100) == true) goto L24;
        r102 = r102 + 1;
        goto L19
    L24:
        return r102;
    L29:
        return -1;
    L11:
        r104 = -1;
        goto L12
    }

    public final void h(Message r100, String r110) {
        Intrinsics.checkNotNullParameter(r100, "preMessage");
        Intrinsics.checkNotNullParameter(r110, "messageId");
        if (this.f424188f.invoke().booleanValue() == false) goto L6;
        return;
    L6:
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == true) goto L9;
        this.f424184b.post(new c(this, r100, r110));
        return;
    L9:
        boolean r101 = false;
        if (r110.length() <= 0) goto L12;
        boolean r102 = true;
    L13:
        Integer r103 = null;
        if (r102 == true) goto L17;
        r110 = null;
    L17:
        if (r110 != null) goto L19;
        return;
    L19:
        String r104 = r100.getcId();
        if (r104 != null) goto L22;
    L27:
        r104 = null;
    L28:
        Iterator<n5b.a> r105 = this.f424185c.iterator();
        int r106 = 0;
    L29:
        int r107 = -1;
        if (r105.hasNext() == false) goto L35;
        if (i(r105.next(), r110) == true) goto L37;
        r106 = r106 + 1;
    L37:
        if (r100.getType() != Message.Type.MEDIA) goto L42;
        int r108 = d(r100);
        if (r108 < 0) goto L41;
    L40:
        r107 = r108;
    L50:
        Integer r109 = Integer.valueOf(r106);
        if (r109.intValue() < 0) goto L53;
        r101 = true;
    L53:
        if (r101 == false) goto L55;
        r103 = r109;
    L55:
        if (r103 == null) goto L57;
        int r111 = r103.intValue();
    L58:
        if (r111 >= 0) goto L60;
        return;
    L60:
        n5b.a r112 = (n5b.a) ListProtector.get(this.f424185c, r111);
        ThreadTopic r113 = r112.f518077b;
        if (r113 == null) goto L63;
        r113.setId(r110);
    L63:
        ThreadTopic r114 = r112.f518077b;
        if (r114 == null) goto L66;
        r114.setRootMsgId(r110);
    L66:
        Message r115 = r112.f518078c;
        if (r115 == null) goto L69;
        r115.setId(r110);
    L69:
        Message r116 = r112.f518078c;
        if (r116 == null) goto L72;
        r116.setSendStatus(SendStatus.SUCCESS);
    L72:
        if (r106 < 0) goto L76;
        if (r107 < 0) goto L76;
        if (r106 == r107) goto L76;
        ListProtector.remove(this.f424185c, r107);
    L76:
        if (r104 == null) goto L78;
        Message r117 = this.f424186d.remove(r104);
    L78:
        this.f424189g.invoke();
        return;
    L57:
        r111 = r107;
        goto L58
    L41:
        r107 = e(r100, r104);
        goto L50
    L42:
        if (r104 == null) goto L50;
        Iterator<n5b.a> r118 = this.f424185c.iterator();
        r108 = 0;
    L45:
        if (r118.hasNext() == false) goto L50;
        if (i(r118.next(), r104) == true) goto L40;
        r108 = r108 + 1;
        goto L45
    L35:
        r106 = -1;
        goto L37
    L22:
        if (r104.length() <= 0) goto L24;
        boolean r119 = true;
    L25:
        if (r119 == false) goto L27;
    L24:
        r119 = false;
        goto L25
    L12:
        r102 = false;
        goto L13
    }

    public static final void a(FlowThreadWindowMediaRootStateHandler r100, String r101, ErrorResult r102) {
        if (r100.f424188f.invoke().booleanValue() == false) goto L6;
        return;
    L6:
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == true) goto L8;
        r100.f424184b.post(new k(r100, r101, r102));
        return;
    L8:
        Iterator<n5b.a> r103 = r100.f424185c.iterator();
        int r104 = 0;
    L10:
        if (r103.hasNext() == false) goto L40;
        n5b.a r105 = r103.next();
        Message r106 = r105.f518078c;
        String r107 = null;
        if (r106 == null) goto L14;
        String r108 = r106.getcId();
    L16:
        if (Intrinsics.areEqual(r108, r101) == true) goto L36;
        Message r109 = r105.f518078c;
        if (r109 == null) goto L20;
        String r110 = r109.getId();
    L22:
        if (Intrinsics.areEqual(r110, r101) == true) goto L36;
        ThreadTopic r111 = r105.f518077b;
        if (r111 == null) goto L26;
        String r112 = r111.getId();
    L28:
        if (Intrinsics.areEqual(r112, r101) == true) goto L36;
        ThreadTopic r113 = r105.f518077b;
        if (r113 == null) goto L33;
        r107 = r113.getRootMsgId();
    L33:
        if (Intrinsics.areEqual(r107, r101) == true) goto L36;
        boolean r114 = false;
    L37:
        if (r114 == true) goto L41;
        r104 = r104 + 1;
    L41:
        if (r104 >= 0) goto L43;
        r100.f(r102);
        return;
    L43:
        Message r115 = ((n5b.a) ListProtector.get(r100.f424185c, r104)).f518078c;
        if (r115 != null) goto L47;
        return;
    L47:
        if (r115.getSendStatus() == SendStatus.SUCCESS) goto L57;
        r115.setSendStatus(SendStatus.FAIL);
        r100.f424189g.invoke();
        r100.f(r102);
        return;
    L57:
        return;
    L26:
        r112 = null;
        goto L28
    L20:
        r110 = null;
    L36:
        r114 = true;
        goto L37
    L14:
        r108 = null;
        goto L16
    L40:
        r104 = -1;
        goto L41
    }

    public final boolean k(String r100, Function1<? super f5b.b, ? extends f5b.b> r101, final Function1<? super SendStatus, Boolean> r102) {
        final String r103 = n.b(r100);
        boolean r104 = false;
        if (r103 != null) goto L5;
        return false;
    L5:
        Function1<n5b.a, Boolean> r105 = new FlowThreadWindowMediaRootStateHandler$patchLoadedMediaRoot$2(r102, this, r103);
        Iterator<Integer> r106 = CollectionsKt.getIndices(this.f424185c).iterator();
    L7:
        if (r106.hasNext() == false) goto L17;
        int r107 = ((IntIterator) r106).nextInt();
        n5b.a r108 = (n5b.a) ListProtector.get(this.f424185c, r107);
        if (r105.invoke(r108).booleanValue() == false) goto L7;
        f5b.b r109 = r101.invoke(r108);
        if ((r109 instanceof n5b.a) == false) goto L13;
        n5b.a r110 = (n5b.a) r109;
    L14:
        if (r110 == null) goto L7;
        ListProtector.set(this.f424185c, r107, r110);
        r104 = true;
        goto L7
    L13:
        r110 = null;
        goto L14
    L17:
        if (r104 == false) goto L19;
        this.f424189g.invoke();
    L19:
        return r104;
    }

    public FlowThreadWindowMediaRootStateHandler(String r100, Handler r101, List<n5b.a> r102, Map<String, Message> r103, MutableLiveData<String> r104, Function0<Boolean> r105, Function0<Unit> r106) {
        Intrinsics.checkNotNullParameter(r100, "chatId");
        Intrinsics.checkNotNullParameter(r101, "mainHandler");
        Intrinsics.checkNotNullParameter(r102, "threads");
        Intrinsics.checkNotNullParameter(r103, "pendingRootPlaceholders");
        Intrinsics.checkNotNullParameter(r104, "toastInfo");
        Intrinsics.checkNotNullParameter(r105, "isDestroyed");
        Intrinsics.checkNotNullParameter(r106, "publishThreads");
        this.f424183a = r100;
        this.f424184b = r101;
        this.f424185c = r102;
        this.f424186d = r103;
        this.f424187e = r104;
        this.f424188f = r105;
        this.f424189g = r106;
    }
}
