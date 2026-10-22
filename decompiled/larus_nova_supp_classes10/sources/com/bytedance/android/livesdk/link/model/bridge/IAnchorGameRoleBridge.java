package com.bytedance.android.livesdk.link.model.bridge;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\b\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0011R$\u0010\t\u001a\u0004\u0018\u00010\u00028&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\u0003\u0010\u0004\"\u0004\b\u0005\u0010\u0006R$\u0010\u0010\u001a\u0004\u0018\u00010\n8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u000f\u0010\b\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/bridge/IAnchorGameRoleBridge;", "Lvh7/c;", "", "getRole", "()Ljava/lang/Integer;", "setRole", "(Ljava/lang/Integer;)V", "getRole$annotations", "()V", "role", "", "getContent", "()Ljava/lang/String;", "setContent", "(Ljava/lang/String;)V", "getContent$annotations", "content", "OpenGameRole", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface IAnchorGameRoleBridge extends vh7.c<IAnchorGameRoleBridge> {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/bridge/IAnchorGameRoleBridge$OpenGameRole;", "", "OPEN_GAME_ROLE_UNDEFINE", "OPEN_GAME_ROLE_DRIVER", "OPEN_GAME_ROLE_SHOOTER", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final enum OpenGameRole extends Enum<OpenGameRole> {
        public static final OpenGameRole OPEN_GAME_ROLE_DRIVER = null;
        public static final OpenGameRole OPEN_GAME_ROLE_SHOOTER = null;
        public static final OpenGameRole OPEN_GAME_ROLE_UNDEFINE = null;
        public static final /* synthetic */ OpenGameRole[] a = null;

        static {
            OpenGameRole r1 = new OpenGameRole("OPEN_GAME_ROLE_UNDEFINE", 0);
            OPEN_GAME_ROLE_UNDEFINE = r1;
            OpenGameRole r2 = new OpenGameRole("OPEN_GAME_ROLE_DRIVER", 1);
            OPEN_GAME_ROLE_DRIVER = r2;
            OpenGameRole r3 = new OpenGameRole("OPEN_GAME_ROLE_SHOOTER", 2);
            OPEN_GAME_ROLE_SHOOTER = r3;
            a = new OpenGameRole[]{r1, r2, r3};
        }

        public static OpenGameRole valueOf(String r1) {
            return (OpenGameRole) r27.a.a(OpenGameRole.class, r1);
        }

        public static OpenGameRole[] values() {
            return (OpenGameRole[]) a.clone();
        }

        public OpenGameRole(String r1, int r2) {
            super(r1, r2);
        }
    }

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    /* synthetic */ vh7.e castTo(Class r1);

    /* synthetic */ vh7.e castToOrNull(Class r1);

    @FieldName(name = "content")
    String getContent();

    @FieldName(name = "role")
    Integer getRole();

    @FieldName(name = "content#setter")
    void setContent(String r1);

    @FieldName(name = "role#setter")
    void setRole(Integer r1);
}
