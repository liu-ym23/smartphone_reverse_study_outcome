package com.obric.sva.sdk.ipc;

import com.facebook.keyframes.model.KFAnimation;
import com.obric.sva.sdk.base.Constant;
import com.obric.sva.sdk.controller.Global;
import com.obric.sva.sdk.utils.LogUtils;
import com.xiaomi.mipush.sdk.MiPushClient;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001:\u0002\u0012\u0013B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\bJ\u000e\u0010\f\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\bJ\u0016\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/obric/sva/sdk/ipc/WakeupSettingBus;", "", "<init>", "()V", "TAG", "", "listeners", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lcom/obric/sva/sdk/ipc/WakeupSettingBus$Listener;", MiPushClient.COMMAND_REGISTER, "", "listener", MiPushClient.COMMAND_UNREGISTER, "emit", KFAnimation.PROPERTY_TYPE_JSON_FIELD, "Lcom/obric/sva/sdk/ipc/WakeupSettingBus$Property;", "status", "", "Property", "Listener", "libs_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class WakeupSettingBus {
    public static final WakeupSettingBus INSTANCE = null;
    private static final String TAG = "WakeupSettingBus";
    private static final CopyOnWriteArrayList<Listener> listeners = null;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, d2 = {"Lcom/obric/sva/sdk/ipc/WakeupSettingBus$Listener;", "", "onSettingChanged", "", KFAnimation.PROPERTY_TYPE_JSON_FIELD, "Lcom/obric/sva/sdk/ipc/WakeupSettingBus$Property;", "status", "", "libs_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface Listener {
        void onSettingChanged(Property r100, boolean r101);
    }

    /* JADX INFO: loaded from: classes34.dex */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/obric/sva/sdk/ipc/WakeupSettingBus$Property;", "", "key", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getKey", "()Ljava/lang/String;", "WAKEUP", "BREATH", "BREATH_UPLOAD", "libs_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum Property extends Enum<Property> {
        private static final /* synthetic */ EnumEntries $ENTRIES = null;
        private static final /* synthetic */ Property[] $VALUES = null;
        public static final Property BREATH = null;
        public static final Property BREATH_UPLOAD = null;
        public static final Property WAKEUP = null;
        private final String key;

        private static final /* synthetic */ Property[] $values() {
            return new Property[]{WAKEUP, BREATH, BREATH_UPLOAD};
        }

        public static EnumEntries<Property> getEntries() {
            return $ENTRIES;
        }

        static {
            WAKEUP = new Property("WAKEUP", 0, Global.SETTINGS_VOICE_ASSISTANT_WAKEUP_STATUS);
            BREATH = new Property("BREATH", 1, Constant.BREATH_WAKEUP_STATUS);
            BREATH_UPLOAD = new Property("BREATH_UPLOAD", 2, Constant.BREATH_DATA_UPLOAD_STATUS);
            Property[] r100 = $values();
            $VALUES = r100;
            $ENTRIES = EnumEntriesKt.enumEntries(r100);
        }

        public static Property[] values() {
            return (Property[]) $VALUES.clone();
        }

        public final String getKey() {
            return this.key;
        }

        public static Property valueOf(String r100) {
            return (Property) r27.a.a(Property.class, r100);
        }

        private Property(String r100, int r101, String r102) {
            super(r100, r101);
            this.key = r102;
        }
    }

    private WakeupSettingBus() {
    }

    static {
        INSTANCE = new WakeupSettingBus();
        listeners = new CopyOnWriteArrayList();
    }

    public final void register(Listener r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        CopyOnWriteArrayList<Listener> r101 = listeners;
        if (r101.contains(r100) == true) goto L6;
        r101.add(r100);
        return;
    }

    public final void unregister(Listener r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        listeners.remove(r100);
    }

    public final void emit(Property r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, KFAnimation.PROPERTY_TYPE_JSON_FIELD);
        StringBuilder r102 = new StringBuilder("emit property=");
        r102.append(r100.getKey());
        r102.append(" status=");
        r102.append(r101);
        r102.append(" listeners=");
        CopyOnWriteArrayList<Listener> r103 = listeners;
        r102.append(r103.size());
        LogUtils.d(TAG, r102.toString(), new Object[0]);
        Iterator<Listener> r104 = r103.iterator();
    L4:
        if (r104.hasNext() == false) goto L10;
        r104.next().onSettingChanged(r100, r101);     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        LogUtils.e(TAG, "listener onSettingChanged failed: " + th.getMessage(), new Object[0]);
        goto L4
    }
}
