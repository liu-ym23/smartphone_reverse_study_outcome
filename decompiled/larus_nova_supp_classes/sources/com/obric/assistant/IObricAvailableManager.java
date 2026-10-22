package com.obric.assistant;

import android.content.Context;
import android.util.EventsUtils;
import com.obric.assistant.common.spi.ObricFeatureServiceDelegate;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bg\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\r\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH&J\b\u0010\u000e\u001a\u00020\u0003H&J\b\u0010\u000f\u001a\u00020\bH\u0016R\u0018\u0010\u0002\u001a\u00020\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\u0002\u0010\u0004\"\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/obric/assistant/IObricAvailableManager;", XmlPullParser.NO_NAMESPACE, "isDefaultAssistant", XmlPullParser.NO_NAMESPACE, "()Z", "setDefaultAssistant", "(Z)V", "startListening", XmlPullParser.NO_NAMESPACE, "context", "Landroid/content/Context;", "listener", "Lcom/obric/assistant/OnRoleAssistantSwitchListener;", "init", "getIsDefaultAssistant", "stopListening", "Companion", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = EventsUtils.FEAT_TYPE_STORAGE_ANTIAGING_EVENT)
public interface IObricAvailableManager {
    public static final a a = null;

    public static final class a {
        public static final /* synthetic */ a a = null;

        static {
            a = new a();
        }

        public a() {
        }

        public static IObricAvailableManager a() {
            if (ObricFeatureServiceDelegate.b.c() == true) goto L7;
            return null;
        L7:
            return (IObricAvailableManager) ServiceManager.get().getService(IObricAvailableManager.class);
        }
    }

    static {
        a = a.a;
    }

    boolean a();

    boolean b();

    void init(Context r1);
}
