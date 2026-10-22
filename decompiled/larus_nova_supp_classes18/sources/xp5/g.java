package xp5;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class g extends sa5.e {
    public final AppCompatActivity a;

    public void k(Intent r1) {
    }

    public void l(Bundle r1) {
    }

    public final AppCompatActivity getActivity() {
        return this.a;
    }

    public g(AppCompatActivity r2) {
        Intrinsics.checkNotNullParameter(r2, "activity");
        this.a = r2;
    }
}
