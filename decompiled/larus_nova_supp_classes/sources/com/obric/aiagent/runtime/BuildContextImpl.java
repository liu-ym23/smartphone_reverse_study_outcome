package com.obric.aiagent.runtime;

import android.util.EventsUtils;
import com.obric.aiagent.platform.depend.IBuildContext;
import kotlin.Metadata;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016J\b\u0010\t\u001a\u00020\u0007H\u0016J\b\u0010\n\u001a\u00020\u0007H\u0016¨\u0006\u000b"}, d2 = {"Lcom/obric/aiagent/runtime/BuildContextImpl;", "Lcom/obric/aiagent/platform/depend/IBuildContext;", "<init>", "()V", "getBuildId", XmlPullParser.NO_NAMESPACE, "getBuildTime", XmlPullParser.NO_NAMESPACE, "getBranchId", "getCommitId", "getBuildVariant", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = EventsUtils.FEAT_TYPE_STORAGE_ANTIAGING_EVENT)
public final class BuildContextImpl implements IBuildContext {
    public BuildContextImpl() {
    }

    @Override // com.obric.aiagent.platform.depend.IBuildContext
    public final String a() {
        return "obric";
    }
}
