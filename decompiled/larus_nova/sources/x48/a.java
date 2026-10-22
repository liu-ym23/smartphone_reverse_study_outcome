package x48;

import com.larus.ui.arch.modulizer.di.ContainerFilter;
import java.util.List;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final List<ContainerFilter> f562447a = null;

    static {
        ContainerFilter r100 = ContainerFilter.CHAT_JOB_MANAGEMENT;
        f562447a = CollectionsKt.listOf(new ContainerFilter[]{ContainerFilter.DOUYIN, ContainerFilter.MINOR_MODE, ContainerFilter.INPUT_MULTI_MODAL, ContainerFilter.FLOAT_CHAT, ContainerFilter.SMART_REPLY, ContainerFilter.AI_FLOAT_CHAT, r100, ContainerFilter.DEFAULT, ContainerFilter.INPUT_ONLY, r100});
    }
}
