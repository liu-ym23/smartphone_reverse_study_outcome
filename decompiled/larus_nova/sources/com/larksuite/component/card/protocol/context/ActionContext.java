package com.larksuite.component.card.protocol.context;

import com.google.gson.JsonObject;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/larksuite/component/card/protocol/context/ActionContext;", "Ljava/io/Serializable;", "<init>", "()V", "toJson", "Lcom/google/gson/JsonObject;", "universalcard_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class ActionContext implements Serializable {
    public ActionContext() {
    }

    public abstract JsonObject toJson();
}
