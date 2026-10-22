package kotlin.reflect.jvm.internal.impl.descriptors;

import com.huawei.hms.push.constant.RemoteMessageConst;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.ReceiverValue;

/* JADX INFO: loaded from: classes5.dex */
public abstract class DescriptorVisibility {
    public DescriptorVisibility() {
    }

    public abstract Visibility getDelegate();

    public abstract String getInternalDisplayName();

    public abstract boolean isVisible(ReceiverValue r100, DeclarationDescriptorWithVisibility r101, DeclarationDescriptor r102, boolean r103);

    public abstract DescriptorVisibility normalize();

    public final boolean isPublicAPI() {
        return getDelegate().isPublicAPI();
    }

    public final String toString() {
        return getDelegate().toString();
    }

    public final Integer compareTo(DescriptorVisibility r100) {
        Intrinsics.checkNotNullParameter(r100, RemoteMessageConst.Notification.VISIBILITY);
        return getDelegate().compareTo(r100.getDelegate());
    }
}
