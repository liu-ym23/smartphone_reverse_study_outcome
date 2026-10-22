package com.obric.eventkit.eventstaskmanager;

import androidx.exifinterface.media.ExifInterface;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Triple;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a%\u0010\u0004\u001a\u0004\u0018\u00018\u0000\"\b\b\u0000\u0010\u0001*\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0001¢\u0006\u0004\b\u0004\u0010\u0005\"@\u0010\n\u001a(\u0012$\u0012\"\u0012\u0004\u0012\u00020\u0002\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00000\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00000\t0\u00070\u00068\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/obric/eventkit/eventstaskmanager/AppEvent;", ExifInterface.GPS_DIRECTION_TRUE, "", "eventType", "newInstanceByEventType", "(Ljava/lang/String;)Lcom/obric/eventkit/eventstaskmanager/AppEvent;", "", "Lkotlin/Triple;", "Ljava/lang/Class;", "Lkotlin/Function0;", "EVENTS", "Ljava/util/List;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/util/List;", "eventstaskkit_release"}, k = 2, mv = {1, 7, 1})
public final class EventTypeKt {
    private static final List<Triple<String, Class<? extends AppEvent>, Function0<AppEvent>>> EVENTS = null;

    static {
        EVENTS = CollectionsKt.listOf(new Triple[]{new Triple("NOTIFICATION_EVENT", NotificationEvent.class, EventTypeKt$EVENTS$1.INSTANCE), new Triple("ACTIVE_AGENT_EVENT", ActiveAgentEvent.class, EventTypeKt$EVENTS$2.INSTANCE)});
    }

    public static final List<Triple<String, Class<? extends AppEvent>, Function0<AppEvent>>> a() {
        return EVENTS;
    }

    public static final String b(AppEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Iterator<T> r101 = EVENTS.iterator();
    L4:
        if (r101.hasNext() == false) goto L8;
        Object r102 = r101.next();
        if (Intrinsics.areEqual(r100.getClass(), ((Triple) r102).getSecond()) == false) goto L4;
    L9:
        Triple r103 = (Triple) r102;
        if (r103 == null) goto L13;
        String r104 = (String) r103.getFirst();
        if (r104 == null) goto L13;
        return r104;
    L13:
        return "UNKNOWN";
    L8:
        r102 = null;
        goto L9
    }

    public static final <T extends AppEvent> T newInstanceByEventType(String r100) {
        Iterator<T> r101 = EVENTS.iterator();
    L4:
        if (r101.hasNext() == false) goto L8;
        Object r102 = r101.next();
        if (Intrinsics.areEqual(((Triple) r102).getFirst(), r100) == false) goto L4;
    L9:
        Triple r103 = (Triple) r102;
        if (r103 == null) goto L14;
        Function0 r104 = (Function0) r103.getThird();
        if (r104 == null) goto L14;
        AppEvent r105 = (AppEvent) r104.invoke();
    L16:
        if ((r105 instanceof AppEvent) == true) goto L18;
        return null;
    L18:
        return (T) r105;
    L14:
        r105 = null;
        goto L16
    L8:
        r102 = null;
        goto L9
    }
}
