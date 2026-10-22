package zp9;

import com.larus.platform.api.creation.PublisherCreation;
import com.larus.platform.api.creation.UserCreationFromIM;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class x {
    public static final PublisherCreation a(UserCreationFromIM r110) {
        Intrinsics.checkNotNullParameter(r110, "<this>");
        return new PublisherCreation(r110.getCreationId(), r110.getCreationType(), null, null, r110.getPrompt(), null, r110.getRefContent(), null, null, false, r110.getMaterialId(), null, null, null, 15276, null);
    }
}
