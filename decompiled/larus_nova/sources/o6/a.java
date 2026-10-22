package o6;

import com.google.gson.Gson;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes43.dex */
public abstract class a<T> {
    private volatile c settingsManager;
    private volatile T settingsModel;

    public a() {
    }

    public final synchronized T get() {
        monitor-enter(this);
    L9:
        th = move-exception;
        throw th;
    L4:
        if (this.settingsModel != null) goto L6;
        updateSettingsModel();     // Catch: Throwable -> L9
    L6:
        T r100 = this.settingsModel;     // Catch: Throwable -> L9
        monitor-exit(this);
        return r100;
    }

    public abstract String getSettingsKey();

    public abstract Class<T> getSettingsModelClass();

    public abstract c obtainSettingsManager();

    public void onSettingsUpdateFail(int r100, String r101, Throwable r102) {
    }

    private final void updateSettingsModel() {
        Result.Companion r100 = Result.Companion;     // Catch: Throwable -> L4
        getSettingsManager();     // Catch: Throwable -> L4
        this.settingsModel = (T) new Gson().fromJson(null, getSettingsModelClass());     // Catch: Throwable -> L4
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        Result.Companion r101 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
    }

    public final c getSettingsManager() {
        obtainSettingsManager();
        return null;
    }

    public void onSettingsUpdateSuccess(JSONObject r100) {
        updateSettingsModel();
    }
}
