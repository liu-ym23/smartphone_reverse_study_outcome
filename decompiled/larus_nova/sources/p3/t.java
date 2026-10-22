package p3;

import com.bytedance.ai.bridge.method.calendar.remote.Property;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes43.dex */
public final class t implements Property {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Property.NodeInfo f527523c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Property.NodeInfo f527524d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Property.NodeInfo f527525e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Property.NodeInfo f527526f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Property.NodeInfo f527527g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final Property.NodeInfo f527528h = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Set<Property.NodeInfo> f527529b;

    public static final class a {
    }

    static {
        f527523c = new Property.NodeInfo("DAV:", "resourcetype");
        f527524d = new Property.NodeInfo("DAV:", "collection");
        f527525e = new Property.NodeInfo("DAV:", "principal");
        f527526f = new Property.NodeInfo("urn:ietf:params:xml:ns:carddav", "addressbook");
        f527527g = new Property.NodeInfo("urn:ietf:params:xml:ns:caldav", "calendar");
        f527528h = new Property.NodeInfo("http://calendarserver.org/ns/", "subscribed");
    }

    public final String toString() {
        return "[" + CollectionsKt.joinToString$default(this.f527529b, ", ", null, null, 0, null, null, 62, null) + ']';
    }

    public t() {
        this.f527529b = new LinkedHashSet();
    }
}
