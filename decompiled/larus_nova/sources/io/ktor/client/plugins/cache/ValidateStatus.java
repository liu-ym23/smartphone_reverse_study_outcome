package io.ktor.client.plugins.cache;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes41.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0080\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lio/ktor/client/plugins/cache/ValidateStatus;", "", "ShouldValidate", "ShouldNotValidate", "ShouldWarn", "ktor-client-core"}, k = 1, mv = {1, 8, 0})
public final enum ValidateStatus extends Enum<ValidateStatus> {
    public static final ValidateStatus ShouldNotValidate = null;
    public static final ValidateStatus ShouldValidate = null;
    public static final ValidateStatus ShouldWarn = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ValidateStatus[] f491673a = null;

    public static ValidateStatus valueOf(String r100) {
        return (ValidateStatus) r27.a.a(ValidateStatus.class, r100);
    }

    public static ValidateStatus[] values() {
        return (ValidateStatus[]) f491673a.clone();
    }

    static {
        ValidateStatus r100 = new ValidateStatus("ShouldValidate", 0);
        ShouldValidate = r100;
        ValidateStatus r101 = new ValidateStatus("ShouldNotValidate", 1);
        ShouldNotValidate = r101;
        ValidateStatus r102 = new ValidateStatus("ShouldWarn", 2);
        ShouldWarn = r102;
        f491673a = new ValidateStatus[]{r100, r101, r102};
    }

    public ValidateStatus(String r100, int r101) {
        super(r100, r101);
    }
}
