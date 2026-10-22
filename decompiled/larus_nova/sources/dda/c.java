package dda;

import com.larus.bmhome.utils.i;
import com.larus.im.bean.message.Message;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.agent.IObricSemanticApi;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import td8.d;

/* JADX INFO: loaded from: classes32.dex */
public final class c implements td8.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f468036a;

    public static final class a {
    }

    static {
    }

    public c(d r100) {
        Intrinsics.checkNotNullParameter(r100, "taskContext");
        this.f468036a = LazyKt.lazy(new b());
    }

    @Override // td8.c
    public final boolean a(int r100, xc8.b r101, xc8.b r102, List<? extends xc8.b> r103) {
        Intrinsics.checkNotNullParameter(r102, "current");
        Intrinsics.checkNotNullParameter(r103, "input");
        xc8.b r104 = (xc8.b) CollectionsKt.firstOrNull(r103);
        if (r104 == null) goto L9;
        Message r105 = r104.getMessage();
        if (r105 == null) goto L9;
        String r106 = r105.getConversationId();
        if (r106 == null) goto L9;
        boolean r107 = i.g(r106);
    L10:
        IObricSemanticApi r108 = (IObricSemanticApi) this.f468036a.getValue();
        if (r108 == null) goto L20;
        List<Message> r109 = r108.getDeleted();
        if (r109 == null) goto L23;
        if (r107 == true) goto L17;
        return false;
    L17:
        if ((!r109.isEmpty()) == false) goto L22;
        return true;
    L22:
        return false;
    L23:
        return false;
    L20:
        return false;
    L9:
        r107 = false;
        goto L10
    }

    @Override // td8.c
    public final List<xc8.b> b(int r100, xc8.b r101, xc8.b r102, List<xc8.b> r103) {
        Intrinsics.checkNotNullParameter(r102, "current");
        Intrinsics.checkNotNullParameter(r103, "input");
        IObricSemanticApi r104 = (IObricSemanticApi) this.f468036a.getValue();
        if (r104 == null) goto L18;
        List<Message> r105 = r104.getDeleted();
        if (r105 == null) goto L18;
        FLogger.f375446a.d("Pipeline_List_OSemanticCutTask", "process: called, deleted = " + r105);
        List<Message> r106 = r105;
        ArrayList r107 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r106, 10));
        Iterator<T> r108 = r106.iterator();
    L9:
        if (r108.hasNext() == false) goto L11;
        r107.add(((Message) r108.next()).getLocalMessageId());
        goto L9
    L11:
        ArrayList r109 = new ArrayList();
        Iterator<T> r110 = r103.iterator();
    L13:
        if (r110.hasNext() == false) goto L17;
        xc8.b r111 = (xc8.b) r110.next();
        if (r107.contains(r111.getMessage().getLocalMessageId()) == true) goto L13;
        r109.add(r111);
        goto L13
    L17:
        return r109;
    L18:
        return r103;
    }
}
