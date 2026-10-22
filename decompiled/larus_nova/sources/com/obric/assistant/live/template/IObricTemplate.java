package com.obric.assistant.live.template;

import com.obric.livecard.api.entity.IslandWidget;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0019\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/obric/assistant/live/template/IObricTemplate;", "", "create", "Lcom/obric/livecard/api/entity/IslandWidget;", "isDefault", "", "(Ljava/lang/Boolean;)Lcom/obric/livecard/api/entity/IslandWidget;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IObricTemplate {

    public static final class a {
        public static /* synthetic */ IslandWidget a(IObricTemplate r100) {
            return r100.create(Boolean.FALSE);
        }
    }

    IslandWidget create(Boolean r100);
}
