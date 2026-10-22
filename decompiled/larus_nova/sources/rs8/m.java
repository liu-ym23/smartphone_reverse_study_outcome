package rs8;

import com.larus.bmhome.instruction.IInstructionCreator;
import com.larus.bmhome.instruction.IInstructionSubCreator;
import com.larus.common.apphost.AppHost;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.Set;

/* JADX INFO: loaded from: classes26.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final boolean f539131a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Set<IInstructionCreator> f539132b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Set<IInstructionSubCreator> f539133c = null;

    static {
        f539131a = AppHost.f326268a.isTestChannel();
        f539132b = ServiceManager.get().getServices(IInstructionCreator.class, true);
        f539133c = ServiceManager.get().getServices(IInstructionSubCreator.class, true);
    }
}
