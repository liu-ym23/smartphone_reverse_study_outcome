package com.larksuite.component.card.protocol.data.person;

import com.google.gson.JsonObject;
import com.ss.android.lark.log.Log;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.json.JSONException;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B7\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\b\u0010\tJ\u0006\u0010\u0011\u001a\u00020\u0012R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000e¨\u0006\u0014"}, d2 = {"Lcom/larksuite/component/card/protocol/data/person/Character;", "Ljava/io/Serializable;", "type", "", "id", "", "content", "avatarKey", "<init>", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getId", "()Ljava/lang/String;", "getContent", "getAvatarKey", "toJson", "Lcom/google/gson/JsonObject;", "Companion", "universalcard_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class Character implements Serializable {
    public static final a Companion = null;
    public static final String TAG = "Character";
    private final String avatarKey;
    private final String content;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private final String f283902id;
    private final Integer type;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public Character() {
        this(null, null, null, null, 15, null);
    }

    public final JsonObject toJson() {
        JsonObject r100 = new JsonObject();
        r100.addProperty("content", this.content);     // Catch: JSONException -> L5
        r100.addProperty("id", this.f283902id);     // Catch: JSONException -> L5
        r100.addProperty("type", this.type);     // Catch: JSONException -> L5
        r100.addProperty("avatarKey", this.avatarKey);     // Catch: JSONException -> L5
    L6:
        return r100;
    L5:
        Log.e(TAG, "person toJSON error");
        goto L6
    }

    public final String getAvatarKey() {
        return this.avatarKey;
    }

    public final String getContent() {
        return this.content;
    }

    public final String getId() {
        return this.f283902id;
    }

    public final Integer getType() {
        return this.type;
    }

    public Character(Integer r100, String r101, String r102, String r103) {
        this.type = r100;
        this.f283902id = r101;
        this.content = r102;
        this.avatarKey = r103;
    }

    public /* synthetic */ Character(Integer r100, String r101, String r102, String r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r102 = null;
    L12:
        if ((r104 & 8) == 0) goto L14;
        r103 = null;
    L14:
        this(r100, r101, r102, r103);
    }
}
