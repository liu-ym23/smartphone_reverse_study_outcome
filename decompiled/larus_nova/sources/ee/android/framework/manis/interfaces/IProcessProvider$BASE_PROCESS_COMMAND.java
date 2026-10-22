package ee.android.framework.manis.interfaces;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes41.dex */
@Retention(RetentionPolicy.SOURCE)
public @interface IProcessProvider$BASE_PROCESS_COMMAND {
    public static final int COMMAND_BASE_END = 1000;
    public static final int COMMAND_REGISTER_SERVICE_LISTENER = 1;
    public static final int COMMAND_UNKNOWN = 0;
    public static final int COMMAND_UNREGISTER_SERVICE_LISTENER = 2;
}
