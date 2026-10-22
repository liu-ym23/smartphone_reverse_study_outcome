package xp5;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public class g extends sa5.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AppCompatActivity f564733a;

    public void k(Intent r100) {
    }

    public void l(Bundle r100) {
    }

    public final AppCompatActivity getActivity() {
        return this.f564733a;
    }

    public g(AppCompatActivity r100) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        this.f564733a = r100;
    }
}
