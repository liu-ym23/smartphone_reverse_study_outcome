package com.ss.android.lark.lynxkit.bridge;

import androidx.exifinterface.media.ExifInterface;
import com.huawei.hms.api.FailedBinderCallBack;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bJ#\u0010\u0006\u001a\u0004\u0018\u0001H\u0007\"\u0004\b\u0000\u0010\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00070\tH&¢\u0006\u0002\u0010\nR\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\f"}, d2 = {"Lcom/ss/android/lark/lynxkit/bridge/LarkLynxBridgeCallContext;", "", FailedBinderCallBack.CALLER_ID, "", "getCallId", "()Ljava/lang/String;", "getService", ExifInterface.GPS_DIRECTION_TRUE, "clazz", "Ljava/lang/Class;", "(Ljava/lang/Class;)Ljava/lang/Object;", "Companion", "lark-lynx-kit_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface LarkLynxBridgeCallContext {
    public static final a Companion = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f431425a = null;

        static {
            f431425a = new a();
        }

        public a() {
        }
    }

    static {
        Companion = a.f431425a;
    }

    String getCallId();

    <T> T getService(Class<T> r100);
}
