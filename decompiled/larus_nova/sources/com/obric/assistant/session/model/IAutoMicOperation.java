package com.obric.assistant.session.model;

import android.os.Parcelable;
import com.bytedance.android.livesdk.schema.BasicTestActionHandler;
import com.obric.assistant.voice.ContentScene;
import kotlin.Metadata;
import zfa.a;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\n\u0010\u0002\u001a\u0004\u0018\u00010\u0003H&J\u001c\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH&J\b\u0010\n\u001a\u00020\u0005H&¨\u0006\u000b"}, d2 = {"Lcom/obric/assistant/session/model/IAutoMicOperation;", "", "getToken", "Lcom/obric/assistant/session/bean/AutoMicToken;", "setToken", "", "scene", "Lcom/obric/assistant/voice/ContentScene;", "data", "Landroid/os/Parcelable;", BasicTestActionHandler.TEST_ACTION_RESET, "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IAutoMicOperation {
    void a(ContentScene r100, Parcelable r101);

    a getToken();

    void reset();
}
