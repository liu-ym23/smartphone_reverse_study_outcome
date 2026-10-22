package s2b;

import com.larksuite.framework.utils.AndroidThrottle;
import com.ss.android.lark.chat.entity.message.MessageInfo;
import java.util.Collection;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class p<T> implements AndroidThrottle.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ o f540407a;

    public p(o r100) {
        this.f540407a = r100;
    }

    @Override // com.larksuite.framework.utils.AndroidThrottle.e
    public final void a(Collection<MessageInfo> r100) {
        Intrinsics.checkNotNullParameter(r100, "tasks");
        this.f540407a.e(r100, false, null);
    }
}
