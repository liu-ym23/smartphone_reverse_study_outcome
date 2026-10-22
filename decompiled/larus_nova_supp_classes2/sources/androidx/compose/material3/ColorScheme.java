package androidx.compose.material3;

import androidx.appcompat.widget.RtlSpacingHelper;
import androidx.biometric.BiometricManager$Authenticators;
import androidx.compose.ui.graphics.Color;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000Ð\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\bm\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0087\u0003\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\u0006\u0010\u000e\u001a\u00020\u0003\u0012\u0006\u0010\u000f\u001a\u00020\u0003\u0012\u0006\u0010\u0010\u001a\u00020\u0003\u0012\u0006\u0010\u0011\u001a\u00020\u0003\u0012\u0006\u0010\u0012\u001a\u00020\u0003\u0012\u0006\u0010\u0013\u001a\u00020\u0003\u0012\u0006\u0010\u0014\u001a\u00020\u0003\u0012\u0006\u0010\u0015\u001a\u00020\u0003\u0012\u0006\u0010\u0016\u001a\u00020\u0003\u0012\u0006\u0010\u0017\u001a\u00020\u0003\u0012\u0006\u0010\u0018\u001a\u00020\u0003\u0012\u0006\u0010\u0019\u001a\u00020\u0003\u0012\u0006\u0010\u001a\u001a\u00020\u0003\u0012\u0006\u0010\u001b\u001a\u00020\u0003\u0012\u0006\u0010\u001c\u001a\u00020\u0003\u0012\u0006\u0010\u001d\u001a\u00020\u0003\u0012\u0006\u0010\u001e\u001a\u00020\u0003\u0012\u0006\u0010\u001f\u001a\u00020\u0003\u0012\u0006\u0010 \u001a\u00020\u0003\u0012\u0006\u0010!\u001a\u00020\u0003\u0012\u0006\u0010\"\u001a\u00020\u0003\u0012\u0006\u0010#\u001a\u00020\u0003\u0012\u0006\u0010$\u001a\u00020\u0003\u0012\u0006\u0010%\u001a\u00020\u0003\u0012\u0006\u0010&\u001a\u00020\u0003\u0012\u0006\u0010'\u001a\u00020\u0003\u0012\u0006\u0010(\u001a\u00020\u0003\u0012\u0006\u0010)\u001a\u00020\u0003\u0012\u0006\u0010*\u001a\u00020\u0003\u0012\u0006\u0010+\u001a\u00020\u0003\u0012\u0006\u0010,\u001a\u00020\u0003\u0012\u0006\u0010-\u001a\u00020\u0003\u0012\u0006\u0010.\u001a\u00020\u0003\u0012\u0006\u0010/\u001a\u00020\u0003\u0012\u0006\u00100\u001a\u00020\u0003\u0012\u0006\u00101\u001a\u00020\u0003\u0012\u0006\u00102\u001a\u00020\u0003¢\u0006\u0004\b3\u00104B©\u0002\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\u0006\u0010\u000e\u001a\u00020\u0003\u0012\u0006\u0010\u000f\u001a\u00020\u0003\u0012\u0006\u0010\u0010\u001a\u00020\u0003\u0012\u0006\u0010\u0011\u001a\u00020\u0003\u0012\u0006\u0010\u0012\u001a\u00020\u0003\u0012\u0006\u0010\u0013\u001a\u00020\u0003\u0012\u0006\u0010\u0014\u001a\u00020\u0003\u0012\u0006\u0010\u0015\u001a\u00020\u0003\u0012\u0006\u0010\u0016\u001a\u00020\u0003\u0012\u0006\u0010\u0017\u001a\u00020\u0003\u0012\u0006\u0010\u0018\u001a\u00020\u0003\u0012\u0006\u0010\u0019\u001a\u00020\u0003\u0012\u0006\u0010\u001a\u001a\u00020\u0003\u0012\u0006\u0010\u001b\u001a\u00020\u0003\u0012\u0006\u0010\u001c\u001a\u00020\u0003\u0012\u0006\u0010\u001d\u001a\u00020\u0003\u0012\u0006\u0010\u001e\u001a\u00020\u0003\u0012\u0006\u0010\u001f\u001a\u00020\u0003\u0012\u0006\u0010 \u001a\u00020\u0003\u0012\u0006\u0010!\u001a\u00020\u0003\u0012\u0006\u0010\"\u001a\u00020\u0003\u0012\u0006\u0010#\u001a\u00020\u0003\u0012\u0006\u0010$\u001a\u00020\u0003\u0012\u0006\u0010%\u001a\u00020\u0003\u0012\u0006\u0010&\u001a\u00020\u0003¢\u0006\u0004\b3\u00105Bñ\u0001\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\u0006\u0010\u000e\u001a\u00020\u0003\u0012\u0006\u0010\u000f\u001a\u00020\u0003\u0012\u0006\u0010\u0010\u001a\u00020\u0003\u0012\u0006\u0010\u0011\u001a\u00020\u0003\u0012\u0006\u0010\u0012\u001a\u00020\u0003\u0012\u0006\u0010\u0013\u001a\u00020\u0003\u0012\u0006\u0010\u0014\u001a\u00020\u0003\u0012\u0006\u0010\u0015\u001a\u00020\u0003\u0012\u0006\u0010\u0016\u001a\u00020\u0003\u0012\u0006\u0010\u0017\u001a\u00020\u0003\u0012\u0006\u0010\u0018\u001a\u00020\u0003\u0012\u0006\u0010\u0019\u001a\u00020\u0003\u0012\u0006\u0010\u001a\u001a\u00020\u0003\u0012\u0006\u0010\u001b\u001a\u00020\u0003\u0012\u0006\u0010\u001c\u001a\u00020\u0003\u0012\u0006\u0010\u001d\u001a\u00020\u0003\u0012\u0006\u0010\u001e\u001a\u00020\u0003\u0012\u0006\u0010\u001f\u001a\u00020\u0003¢\u0006\u0004\b3\u00106Jí\u0003\u0010i\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u00032\b\b\u0002\u0010\u0010\u001a\u00020\u00032\b\b\u0002\u0010\u0011\u001a\u00020\u00032\b\b\u0002\u0010\u0012\u001a\u00020\u00032\b\b\u0002\u0010\u0013\u001a\u00020\u00032\b\b\u0002\u0010\u0014\u001a\u00020\u00032\b\b\u0002\u0010\u0015\u001a\u00020\u00032\b\b\u0002\u0010\u0016\u001a\u00020\u00032\b\b\u0002\u0010\u0017\u001a\u00020\u00032\b\b\u0002\u0010\u0018\u001a\u00020\u00032\b\b\u0002\u0010\u0019\u001a\u00020\u00032\b\b\u0002\u0010\u001a\u001a\u00020\u00032\b\b\u0002\u0010\u001b\u001a\u00020\u00032\b\b\u0002\u0010\u001c\u001a\u00020\u00032\b\b\u0002\u0010\u001d\u001a\u00020\u00032\b\b\u0002\u0010\u001e\u001a\u00020\u00032\b\b\u0002\u0010\u001f\u001a\u00020\u00032\b\b\u0002\u0010 \u001a\u00020\u00032\b\b\u0002\u0010!\u001a\u00020\u00032\b\b\u0002\u0010\"\u001a\u00020\u00032\b\b\u0002\u0010#\u001a\u00020\u00032\b\b\u0002\u0010$\u001a\u00020\u00032\b\b\u0002\u0010%\u001a\u00020\u00032\b\b\u0002\u0010&\u001a\u00020\u00032\b\b\u0002\u0010'\u001a\u00020\u00032\b\b\u0002\u0010(\u001a\u00020\u00032\b\b\u0002\u0010)\u001a\u00020\u00032\b\b\u0002\u0010*\u001a\u00020\u00032\b\b\u0002\u0010+\u001a\u00020\u00032\b\b\u0002\u0010,\u001a\u00020\u00032\b\b\u0002\u0010-\u001a\u00020\u00032\b\b\u0002\u0010.\u001a\u00020\u00032\b\b\u0002\u0010/\u001a\u00020\u00032\b\b\u0002\u00100\u001a\u00020\u00032\b\b\u0002\u00101\u001a\u00020\u00032\b\b\u0002\u00102\u001a\u00020\u0003¢\u0006\u0004\bj\u0010kJ±\u0002\u0010i\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u00032\b\b\u0002\u0010\u0010\u001a\u00020\u00032\b\b\u0002\u0010\u0011\u001a\u00020\u00032\b\b\u0002\u0010\u0012\u001a\u00020\u00032\b\b\u0002\u0010\u0013\u001a\u00020\u00032\b\b\u0002\u0010\u0014\u001a\u00020\u00032\b\b\u0002\u0010\u0015\u001a\u00020\u00032\b\b\u0002\u0010\u0016\u001a\u00020\u00032\b\b\u0002\u0010\u0017\u001a\u00020\u00032\b\b\u0002\u0010\u0018\u001a\u00020\u00032\b\b\u0002\u0010\u0019\u001a\u00020\u00032\b\b\u0002\u0010\u001a\u001a\u00020\u00032\b\b\u0002\u0010\u001b\u001a\u00020\u00032\b\b\u0002\u0010\u001c\u001a\u00020\u00032\b\b\u0002\u0010\u001d\u001a\u00020\u00032\b\b\u0002\u0010\u001e\u001a\u00020\u00032\b\b\u0002\u0010\u001f\u001a\u00020\u0003H\u0007¢\u0006\u0004\bl\u0010mJ÷\u0002\u0010i\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u00032\b\b\u0002\u0010\u0010\u001a\u00020\u00032\b\b\u0002\u0010\u0011\u001a\u00020\u00032\b\b\u0002\u0010\u0012\u001a\u00020\u00032\b\b\u0002\u0010\u0013\u001a\u00020\u00032\b\b\u0002\u0010\u0014\u001a\u00020\u00032\b\b\u0002\u0010\u0015\u001a\u00020\u00032\b\b\u0002\u0010\u0016\u001a\u00020\u00032\b\b\u0002\u0010\u0017\u001a\u00020\u00032\b\b\u0002\u0010\u0018\u001a\u00020\u00032\b\b\u0002\u0010\u0019\u001a\u00020\u00032\b\b\u0002\u0010\u001a\u001a\u00020\u00032\b\b\u0002\u0010\u001b\u001a\u00020\u00032\b\b\u0002\u0010\u001c\u001a\u00020\u00032\b\b\u0002\u0010\u001d\u001a\u00020\u00032\b\b\u0002\u0010\u001e\u001a\u00020\u00032\b\b\u0002\u0010\u001f\u001a\u00020\u00032\b\b\u0002\u0010 \u001a\u00020\u00032\b\b\u0002\u0010!\u001a\u00020\u00032\b\b\u0002\u0010\"\u001a\u00020\u00032\b\b\u0002\u0010#\u001a\u00020\u00032\b\b\u0002\u0010$\u001a\u00020\u00032\b\b\u0002\u0010%\u001a\u00020\u00032\b\b\u0002\u0010&\u001a\u00020\u0003H\u0007¢\u0006\u0004\bn\u0010oJ\b\u0010p\u001a\u00020qH\u0016R\u0013\u0010\u0002\u001a\u00020\u0003¢\u0006\n\n\u0002\u00109\u001a\u0004\b7\u00108R\u0013\u0010\u0004\u001a\u00020\u0003¢\u0006\n\n\u0002\u00109\u001a\u0004\b:\u00108R\u0013\u0010\u0005\u001a\u00020\u0003¢\u0006\n\n\u0002\u00109\u001a\u0004\b;\u00108R\u0013\u0010\u0006\u001a\u00020\u0003¢\u0006\n\n\u0002\u00109\u001a\u0004\b<\u00108R\u0013\u0010\u0007\u001a\u00020\u0003¢\u0006\n\n\u0002\u00109\u001a\u0004\b=\u00108R\u0013\u0010\b\u001a\u00020\u0003¢\u0006\n\n\u0002\u00109\u001a\u0004\b>\u00108R\u0013\u0010\t\u001a\u00020\u0003¢\u0006\n\n\u0002\u00109\u001a\u0004\b?\u00108R\u0013\u0010\n\u001a\u00020\u0003¢\u0006\n\n\u0002\u00109\u001a\u0004\b@\u00108R\u0013\u0010\u000b\u001a\u00020\u0003¢\u0006\n\n\u0002\u00109\u001a\u0004\bA\u00108R\u0013\u0010\f\u001a\u00020\u0003¢\u0006\n\n\u0002\u00109\u001a\u0004\bB\u00108R\u0013\u0010\r\u001a\u00020\u0003¢\u0006\n\n\u0002\u00109\u001a\u0004\bC\u00108R\u0013\u0010\u000e\u001a\u00020\u0003¢\u0006\n\n\u0002\u00109\u001a\u0004\bD\u00108R\u0013\u0010\u000f\u001a\u00020\u0003¢\u0006\n\n\u0002\u00109\u001a\u0004\bE\u00108R\u0013\u0010\u0010\u001a\u00020\u0003¢\u0006\n\n\u0002\u00109\u001a\u0004\bF\u00108R\u0013\u0010\u0011\u001a\u00020\u0003¢\u0006\n\n\u0002\u00109\u001a\u0004\bG\u00108R\u0013\u0010\u0012\u001a\u00020\u0003¢\u0006\n\n\u0002\u00109\u001a\u0004\bH\u00108R\u0013\u0010\u0013\u001a\u00020\u0003¢\u0006\n\n\u0002\u00109\u001a\u0004\bI\u00108R\u0013\u0010\u0014\u001a\u00020\u0003¢\u0006\n\n\u0002\u00109\u001a\u0004\bJ\u00108R\u0013\u0010\u0015\u001a\u00020\u0003¢\u0006\n\n\u0002\u00109\u001a\u0004\bK\u00108R\u0013\u0010\u0016\u001a\u00020\u0003¢\u0006\n\n\u0002\u00109\u001a\u0004\bL\u00108R\u0013\u0010\u0017\u001a\u00020\u0003¢\u0006\n\n\u0002\u00109\u001a\u0004\bM\u00108R\u0013\u0010\u0018\u001a\u00020\u0003¢\u0006\n\n\u0002\u00109\u001a\u0004\bN\u00108R\u0013\u0010\u0019\u001a\u00020\u0003¢\u0006\n\n\u0002\u00109\u001a\u0004\bO\u00108R\u0013\u0010\u001a\u001a\u00020\u0003¢\u0006\n\n\u0002\u00109\u001a\u0004\bP\u00108R\u0013\u0010\u001b\u001a\u00020\u0003¢\u0006\n\n\u0002\u00109\u001a\u0004\bQ\u00108R\u0013\u0010\u001c\u001a\u00020\u0003¢\u0006\n\n\u0002\u00109\u001a\u0004\bR\u00108R\u0013\u0010\u001d\u001a\u00020\u0003¢\u0006\n\n\u0002\u00109\u001a\u0004\bS\u00108R\u0013\u0010\u001e\u001a\u00020\u0003¢\u0006\n\n\u0002\u00109\u001a\u0004\bT\u00108R\u0013\u0010\u001f\u001a\u00020\u0003¢\u0006\n\n\u0002\u00109\u001a\u0004\bU\u00108R\u0013\u0010 \u001a\u00020\u0003¢\u0006\n\n\u0002\u00109\u001a\u0004\bV\u00108R\u0013\u0010!\u001a\u00020\u0003¢\u0006\n\n\u0002\u00109\u001a\u0004\bW\u00108R\u0013\u0010\"\u001a\u00020\u0003¢\u0006\n\n\u0002\u00109\u001a\u0004\bX\u00108R\u0013\u0010#\u001a\u00020\u0003¢\u0006\n\n\u0002\u00109\u001a\u0004\bY\u00108R\u0013\u0010$\u001a\u00020\u0003¢\u0006\n\n\u0002\u00109\u001a\u0004\bZ\u00108R\u0013\u0010%\u001a\u00020\u0003¢\u0006\n\n\u0002\u00109\u001a\u0004\b[\u00108R\u0013\u0010&\u001a\u00020\u0003¢\u0006\n\n\u0002\u00109\u001a\u0004\b\\\u00108R\u0013\u0010'\u001a\u00020\u0003¢\u0006\n\n\u0002\u00109\u001a\u0004\b]\u00108R\u0013\u0010(\u001a\u00020\u0003¢\u0006\n\n\u0002\u00109\u001a\u0004\b^\u00108R\u0013\u0010)\u001a\u00020\u0003¢\u0006\n\n\u0002\u00109\u001a\u0004\b_\u00108R\u0013\u0010*\u001a\u00020\u0003¢\u0006\n\n\u0002\u00109\u001a\u0004\b`\u00108R\u0013\u0010+\u001a\u00020\u0003¢\u0006\n\n\u0002\u00109\u001a\u0004\ba\u00108R\u0013\u0010,\u001a\u00020\u0003¢\u0006\n\n\u0002\u00109\u001a\u0004\bb\u00108R\u0013\u0010-\u001a\u00020\u0003¢\u0006\n\n\u0002\u00109\u001a\u0004\bc\u00108R\u0013\u0010.\u001a\u00020\u0003¢\u0006\n\n\u0002\u00109\u001a\u0004\bd\u00108R\u0013\u0010/\u001a\u00020\u0003¢\u0006\n\n\u0002\u00109\u001a\u0004\be\u00108R\u0013\u00100\u001a\u00020\u0003¢\u0006\n\n\u0002\u00109\u001a\u0004\bf\u00108R\u0013\u00101\u001a\u00020\u0003¢\u0006\n\n\u0002\u00109\u001a\u0004\bg\u00108R\u0013\u00102\u001a\u00020\u0003¢\u0006\n\n\u0002\u00109\u001a\u0004\bh\u00108R\u001c\u0010r\u001a\u0004\u0018\u00010sX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bt\u0010u\"\u0004\bv\u0010wR\u001c\u0010x\u001a\u0004\u0018\u00010sX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\by\u0010u\"\u0004\bz\u0010wR\u001c\u0010{\u001a\u0004\u0018\u00010sX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b|\u0010u\"\u0004\b}\u0010wR\u001d\u0010~\u001a\u0004\u0018\u00010sX\u0080\u000e¢\u0006\u000f\n\u0000\u001a\u0004\b\u007f\u0010u\"\u0005\b\u0080\u0001\u0010wR\u001f\u0010\u0081\u0001\u001a\u0004\u0018\u00010sX\u0080\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0082\u0001\u0010u\"\u0005\b\u0083\u0001\u0010wR\"\u0010\u0084\u0001\u001a\u0005\u0018\u00010\u0085\u0001X\u0080\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0086\u0001\u0010\u0087\u0001\"\u0006\b\u0088\u0001\u0010\u0089\u0001R\"\u0010\u008a\u0001\u001a\u0005\u0018\u00010\u0085\u0001X\u0080\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u008b\u0001\u0010\u0087\u0001\"\u0006\b\u008c\u0001\u0010\u0089\u0001R\"\u0010\u008d\u0001\u001a\u0005\u0018\u00010\u0085\u0001X\u0080\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u008e\u0001\u0010\u0087\u0001\"\u0006\b\u008f\u0001\u0010\u0089\u0001R\"\u0010\u0090\u0001\u001a\u0005\u0018\u00010\u0091\u0001X\u0080\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0092\u0001\u0010\u0093\u0001\"\u0006\b\u0094\u0001\u0010\u0095\u0001R\"\u0010\u0096\u0001\u001a\u0005\u0018\u00010\u0091\u0001X\u0080\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0097\u0001\u0010\u0093\u0001\"\u0006\b\u0098\u0001\u0010\u0095\u0001R\"\u0010\u0099\u0001\u001a\u0005\u0018\u00010\u0091\u0001X\u0080\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u009a\u0001\u0010\u0093\u0001\"\u0006\b\u009b\u0001\u0010\u0095\u0001R\"\u0010\u009c\u0001\u001a\u0005\u0018\u00010\u0091\u0001X\u0080\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u009d\u0001\u0010\u0093\u0001\"\u0006\b\u009e\u0001\u0010\u0095\u0001R\"\u0010\u009f\u0001\u001a\u0005\u0018\u00010 \u0001X\u0080\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b¡\u0001\u0010¢\u0001\"\u0006\b£\u0001\u0010¤\u0001R\"\u0010¥\u0001\u001a\u0005\u0018\u00010 \u0001X\u0080\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b¦\u0001\u0010¢\u0001\"\u0006\b§\u0001\u0010¤\u0001R\"\u0010¨\u0001\u001a\u0005\u0018\u00010 \u0001X\u0080\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b©\u0001\u0010¢\u0001\"\u0006\bª\u0001\u0010¤\u0001R\"\u0010«\u0001\u001a\u0005\u0018\u00010¬\u0001X\u0080\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u00ad\u0001\u0010®\u0001\"\u0006\b¯\u0001\u0010°\u0001R*\u0010±\u0001\u001a\u0005\u0018\u00010²\u0001X\u0080\u000e¢\u0006\u001a\n\u0000\u0012\u0006\b³\u0001\u0010´\u0001\u001a\u0006\bµ\u0001\u0010¶\u0001\"\u0006\b·\u0001\u0010¸\u0001R\"\u0010¹\u0001\u001a\u0005\u0018\u00010º\u0001X\u0080\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b»\u0001\u0010¼\u0001\"\u0006\b½\u0001\u0010¾\u0001R*\u0010¿\u0001\u001a\u0005\u0018\u00010À\u0001X\u0080\u000e¢\u0006\u001a\n\u0000\u0012\u0006\bÁ\u0001\u0010´\u0001\u001a\u0006\bÂ\u0001\u0010Ã\u0001\"\u0006\bÄ\u0001\u0010Å\u0001R\"\u0010Æ\u0001\u001a\u0005\u0018\u00010Ç\u0001X\u0080\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bÈ\u0001\u0010É\u0001\"\u0006\bÊ\u0001\u0010Ë\u0001R\"\u0010Ì\u0001\u001a\u0005\u0018\u00010Ç\u0001X\u0080\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bÍ\u0001\u0010É\u0001\"\u0006\bÎ\u0001\u0010Ë\u0001R\"\u0010Ï\u0001\u001a\u0005\u0018\u00010Ð\u0001X\u0080\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bÑ\u0001\u0010Ò\u0001\"\u0006\bÓ\u0001\u0010Ô\u0001R\"\u0010Õ\u0001\u001a\u0005\u0018\u00010Ð\u0001X\u0080\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bÖ\u0001\u0010Ò\u0001\"\u0006\b×\u0001\u0010Ô\u0001R\"\u0010Ø\u0001\u001a\u0005\u0018\u00010Ç\u0001X\u0080\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bÙ\u0001\u0010É\u0001\"\u0006\bÚ\u0001\u0010Ë\u0001R\"\u0010Û\u0001\u001a\u0005\u0018\u00010Ð\u0001X\u0080\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bÜ\u0001\u0010Ò\u0001\"\u0006\bÝ\u0001\u0010Ô\u0001R\"\u0010Þ\u0001\u001a\u0005\u0018\u00010Ç\u0001X\u0080\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bß\u0001\u0010É\u0001\"\u0006\bà\u0001\u0010Ë\u0001R\"\u0010á\u0001\u001a\u0005\u0018\u00010Ð\u0001X\u0080\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bâ\u0001\u0010Ò\u0001\"\u0006\bã\u0001\u0010Ô\u0001R\"\u0010ä\u0001\u001a\u0005\u0018\u00010Ç\u0001X\u0080\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bå\u0001\u0010É\u0001\"\u0006\bæ\u0001\u0010Ë\u0001R\"\u0010ç\u0001\u001a\u0005\u0018\u00010Ç\u0001X\u0080\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bè\u0001\u0010É\u0001\"\u0006\bé\u0001\u0010Ë\u0001R\"\u0010ê\u0001\u001a\u0005\u0018\u00010Ð\u0001X\u0080\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bë\u0001\u0010Ò\u0001\"\u0006\bì\u0001\u0010Ô\u0001R\"\u0010í\u0001\u001a\u0005\u0018\u00010Ð\u0001X\u0080\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bî\u0001\u0010Ò\u0001\"\u0006\bï\u0001\u0010Ô\u0001R\"\u0010ð\u0001\u001a\u0005\u0018\u00010ñ\u0001X\u0080\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bò\u0001\u0010ó\u0001\"\u0006\bô\u0001\u0010õ\u0001R\"\u0010ö\u0001\u001a\u0005\u0018\u00010÷\u0001X\u0080\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bø\u0001\u0010ù\u0001\"\u0006\bú\u0001\u0010û\u0001R\"\u0010ü\u0001\u001a\u0005\u0018\u00010ý\u0001X\u0080\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bþ\u0001\u0010ÿ\u0001\"\u0006\b\u0080\u0002\u0010\u0081\u0002R\"\u0010\u0082\u0002\u001a\u0005\u0018\u00010\u0083\u0002X\u0080\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0084\u0002\u0010\u0085\u0002\"\u0006\b\u0086\u0002\u0010\u0087\u0002R\"\u0010\u0088\u0002\u001a\u0005\u0018\u00010\u0089\u0002X\u0080\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u008a\u0002\u0010\u008b\u0002\"\u0006\b\u008c\u0002\u0010\u008d\u0002R\"\u0010\u008e\u0002\u001a\u0005\u0018\u00010\u008f\u0002X\u0080\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0090\u0002\u0010\u0091\u0002\"\u0006\b\u0092\u0002\u0010\u0093\u0002R\"\u0010\u0094\u0002\u001a\u0005\u0018\u00010\u0083\u0002X\u0080\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0095\u0002\u0010\u0085\u0002\"\u0006\b\u0096\u0002\u0010\u0087\u0002R\"\u0010\u0097\u0002\u001a\u0005\u0018\u00010\u0098\u0002X\u0080\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0099\u0002\u0010\u009a\u0002\"\u0006\b\u009b\u0002\u0010\u009c\u0002R\"\u0010\u009d\u0002\u001a\u0005\u0018\u00010\u009e\u0002X\u0080\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u009f\u0002\u0010 \u0002\"\u0006\b¡\u0002\u0010¢\u0002R\"\u0010£\u0002\u001a\u0005\u0018\u00010¤\u0002X\u0080\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b¥\u0002\u0010¦\u0002\"\u0006\b§\u0002\u0010¨\u0002R\"\u0010©\u0002\u001a\u0005\u0018\u00010ª\u0002X\u0080\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b«\u0002\u0010¬\u0002\"\u0006\b\u00ad\u0002\u0010®\u0002R\"\u0010¯\u0002\u001a\u0005\u0018\u00010°\u0002X\u0080\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b±\u0002\u0010²\u0002\"\u0006\b³\u0002\u0010´\u0002R\"\u0010µ\u0002\u001a\u0005\u0018\u00010°\u0002X\u0080\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b¶\u0002\u0010²\u0002\"\u0006\b·\u0002\u0010´\u0002R*\u0010¸\u0002\u001a\u0005\u0018\u00010¹\u0002X\u0080\u000e¢\u0006\u001a\n\u0000\u0012\u0006\bº\u0002\u0010´\u0001\u001a\u0006\b»\u0002\u0010¼\u0002\"\u0006\b½\u0002\u0010¾\u0002R*\u0010¿\u0002\u001a\u0005\u0018\u00010À\u0002X\u0080\u000e¢\u0006\u001a\n\u0000\u0012\u0006\bÁ\u0002\u0010´\u0001\u001a\u0006\bÂ\u0002\u0010Ã\u0002\"\u0006\bÄ\u0002\u0010Å\u0002¨\u0006Æ\u0002"}, d2 = {"Landroidx/compose/material3/ColorScheme;", "", "primary", "Landroidx/compose/ui/graphics/Color;", "onPrimary", "primaryContainer", "onPrimaryContainer", "inversePrimary", "secondary", "onSecondary", "secondaryContainer", "onSecondaryContainer", "tertiary", "onTertiary", "tertiaryContainer", "onTertiaryContainer", "background", "onBackground", "surface", "onSurface", "surfaceVariant", "onSurfaceVariant", "surfaceTint", "inverseSurface", "inverseOnSurface", "error", "onError", "errorContainer", "onErrorContainer", "outline", "outlineVariant", "scrim", "surfaceBright", "surfaceDim", "surfaceContainer", "surfaceContainerHigh", "surfaceContainerHighest", "surfaceContainerLow", "surfaceContainerLowest", "primaryFixed", "primaryFixedDim", "onPrimaryFixed", "onPrimaryFixedVariant", "secondaryFixed", "secondaryFixedDim", "onSecondaryFixed", "onSecondaryFixedVariant", "tertiaryFixed", "tertiaryFixedDim", "onTertiaryFixed", "onTertiaryFixedVariant", "<init>", "(JJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "(JJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "(JJJJJJJJJJJJJJJJJJJJJJJJJJJJJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getPrimary-0d7_KjU", "()J", "J", "getOnPrimary-0d7_KjU", "getPrimaryContainer-0d7_KjU", "getOnPrimaryContainer-0d7_KjU", "getInversePrimary-0d7_KjU", "getSecondary-0d7_KjU", "getOnSecondary-0d7_KjU", "getSecondaryContainer-0d7_KjU", "getOnSecondaryContainer-0d7_KjU", "getTertiary-0d7_KjU", "getOnTertiary-0d7_KjU", "getTertiaryContainer-0d7_KjU", "getOnTertiaryContainer-0d7_KjU", "getBackground-0d7_KjU", "getOnBackground-0d7_KjU", "getSurface-0d7_KjU", "getOnSurface-0d7_KjU", "getSurfaceVariant-0d7_KjU", "getOnSurfaceVariant-0d7_KjU", "getSurfaceTint-0d7_KjU", "getInverseSurface-0d7_KjU", "getInverseOnSurface-0d7_KjU", "getError-0d7_KjU", "getOnError-0d7_KjU", "getErrorContainer-0d7_KjU", "getOnErrorContainer-0d7_KjU", "getOutline-0d7_KjU", "getOutlineVariant-0d7_KjU", "getScrim-0d7_KjU", "getSurfaceBright-0d7_KjU", "getSurfaceDim-0d7_KjU", "getSurfaceContainer-0d7_KjU", "getSurfaceContainerHigh-0d7_KjU", "getSurfaceContainerHighest-0d7_KjU", "getSurfaceContainerLow-0d7_KjU", "getSurfaceContainerLowest-0d7_KjU", "getPrimaryFixed-0d7_KjU", "getPrimaryFixedDim-0d7_KjU", "getOnPrimaryFixed-0d7_KjU", "getOnPrimaryFixedVariant-0d7_KjU", "getSecondaryFixed-0d7_KjU", "getSecondaryFixedDim-0d7_KjU", "getOnSecondaryFixed-0d7_KjU", "getOnSecondaryFixedVariant-0d7_KjU", "getTertiaryFixed-0d7_KjU", "getTertiaryFixedDim-0d7_KjU", "getOnTertiaryFixed-0d7_KjU", "getOnTertiaryFixedVariant-0d7_KjU", "copy", "copy-_VG5OTI", "(JJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJ)Landroidx/compose/material3/ColorScheme;", "copy-G1PFc-w", "(JJJJJJJJJJJJJJJJJJJJJJJJJJJJJ)Landroidx/compose/material3/ColorScheme;", "copy-C-Xl9yA", "(JJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJ)Landroidx/compose/material3/ColorScheme;", "toString", "", "defaultButtonColorsCached", "Landroidx/compose/material3/ButtonColors;", "getDefaultButtonColorsCached$material3", "()Landroidx/compose/material3/ButtonColors;", "setDefaultButtonColorsCached$material3", "(Landroidx/compose/material3/ButtonColors;)V", "defaultElevatedButtonColorsCached", "getDefaultElevatedButtonColorsCached$material3", "setDefaultElevatedButtonColorsCached$material3", "defaultFilledTonalButtonColorsCached", "getDefaultFilledTonalButtonColorsCached$material3", "setDefaultFilledTonalButtonColorsCached$material3", "defaultOutlinedButtonColorsCached", "getDefaultOutlinedButtonColorsCached$material3", "setDefaultOutlinedButtonColorsCached$material3", "defaultTextButtonColorsCached", "getDefaultTextButtonColorsCached$material3", "setDefaultTextButtonColorsCached$material3", "defaultCardColorsCached", "Landroidx/compose/material3/CardColors;", "getDefaultCardColorsCached$material3", "()Landroidx/compose/material3/CardColors;", "setDefaultCardColorsCached$material3", "(Landroidx/compose/material3/CardColors;)V", "defaultElevatedCardColorsCached", "getDefaultElevatedCardColorsCached$material3", "setDefaultElevatedCardColorsCached$material3", "defaultOutlinedCardColorsCached", "getDefaultOutlinedCardColorsCached$material3", "setDefaultOutlinedCardColorsCached$material3", "defaultAssistChipColorsCached", "Landroidx/compose/material3/ChipColors;", "getDefaultAssistChipColorsCached$material3", "()Landroidx/compose/material3/ChipColors;", "setDefaultAssistChipColorsCached$material3", "(Landroidx/compose/material3/ChipColors;)V", "defaultElevatedAssistChipColorsCached", "getDefaultElevatedAssistChipColorsCached$material3", "setDefaultElevatedAssistChipColorsCached$material3", "defaultSuggestionChipColorsCached", "getDefaultSuggestionChipColorsCached$material3", "setDefaultSuggestionChipColorsCached$material3", "defaultElevatedSuggestionChipColorsCached", "getDefaultElevatedSuggestionChipColorsCached$material3", "setDefaultElevatedSuggestionChipColorsCached$material3", "defaultFilterChipColorsCached", "Landroidx/compose/material3/SelectableChipColors;", "getDefaultFilterChipColorsCached$material3", "()Landroidx/compose/material3/SelectableChipColors;", "setDefaultFilterChipColorsCached$material3", "(Landroidx/compose/material3/SelectableChipColors;)V", "defaultElevatedFilterChipColorsCached", "getDefaultElevatedFilterChipColorsCached$material3", "setDefaultElevatedFilterChipColorsCached$material3", "defaultInputChipColorsCached", "getDefaultInputChipColorsCached$material3", "setDefaultInputChipColorsCached$material3", "defaultVerticalDragHandleColorsCached", "Landroidx/compose/material3/DragHandleColors;", "getDefaultVerticalDragHandleColorsCached$material3", "()Landroidx/compose/material3/DragHandleColors;", "setDefaultVerticalDragHandleColorsCached$material3", "(Landroidx/compose/material3/DragHandleColors;)V", "defaultTopAppBarColorsCached", "Landroidx/compose/material3/TopAppBarColors;", "getDefaultTopAppBarColorsCached$material3$annotations", "()V", "getDefaultTopAppBarColorsCached$material3", "()Landroidx/compose/material3/TopAppBarColors;", "setDefaultTopAppBarColorsCached$material3", "(Landroidx/compose/material3/TopAppBarColors;)V", "defaultCheckboxColorsCached", "Landroidx/compose/material3/CheckboxColors;", "getDefaultCheckboxColorsCached$material3", "()Landroidx/compose/material3/CheckboxColors;", "setDefaultCheckboxColorsCached$material3", "(Landroidx/compose/material3/CheckboxColors;)V", "defaultDatePickerColorsCached", "Landroidx/compose/material3/DatePickerColors;", "getDefaultDatePickerColorsCached$material3$annotations", "getDefaultDatePickerColorsCached$material3", "()Landroidx/compose/material3/DatePickerColors;", "setDefaultDatePickerColorsCached$material3", "(Landroidx/compose/material3/DatePickerColors;)V", "defaultIconButtonColorsCached", "Landroidx/compose/material3/IconButtonColors;", "getDefaultIconButtonColorsCached$material3", "()Landroidx/compose/material3/IconButtonColors;", "setDefaultIconButtonColorsCached$material3", "(Landroidx/compose/material3/IconButtonColors;)V", "defaultIconButtonVibrantColorsCached", "getDefaultIconButtonVibrantColorsCached$material3", "setDefaultIconButtonVibrantColorsCached$material3", "defaultIconToggleButtonColorsCached", "Landroidx/compose/material3/IconToggleButtonColors;", "getDefaultIconToggleButtonColorsCached$material3", "()Landroidx/compose/material3/IconToggleButtonColors;", "setDefaultIconToggleButtonColorsCached$material3", "(Landroidx/compose/material3/IconToggleButtonColors;)V", "defaultIconToggleButtonVibrantColorsCached", "getDefaultIconToggleButtonVibrantColorsCached$material3", "setDefaultIconToggleButtonVibrantColorsCached$material3", "defaultFilledIconButtonColorsCached", "getDefaultFilledIconButtonColorsCached$material3", "setDefaultFilledIconButtonColorsCached$material3", "defaultFilledIconToggleButtonColorsCached", "getDefaultFilledIconToggleButtonColorsCached$material3", "setDefaultFilledIconToggleButtonColorsCached$material3", "defaultFilledTonalIconButtonColorsCached", "getDefaultFilledTonalIconButtonColorsCached$material3", "setDefaultFilledTonalIconButtonColorsCached$material3", "defaultFilledTonalIconToggleButtonColorsCached", "getDefaultFilledTonalIconToggleButtonColorsCached$material3", "setDefaultFilledTonalIconToggleButtonColorsCached$material3", "defaultOutlinedIconButtonColorsCached", "getDefaultOutlinedIconButtonColorsCached$material3", "setDefaultOutlinedIconButtonColorsCached$material3", "defaultOutlinedIconButtonVibrantColorsCached", "getDefaultOutlinedIconButtonVibrantColorsCached$material3", "setDefaultOutlinedIconButtonVibrantColorsCached$material3", "defaultOutlinedIconToggleButtonColorsCached", "getDefaultOutlinedIconToggleButtonColorsCached$material3", "setDefaultOutlinedIconToggleButtonColorsCached$material3", "defaultOutlinedIconToggleButtonVibrantColorsCached", "getDefaultOutlinedIconToggleButtonVibrantColorsCached$material3", "setDefaultOutlinedIconToggleButtonVibrantColorsCached$material3", "defaultListItemColorsCached", "Landroidx/compose/material3/ListItemColors;", "getDefaultListItemColorsCached$material3", "()Landroidx/compose/material3/ListItemColors;", "setDefaultListItemColorsCached$material3", "(Landroidx/compose/material3/ListItemColors;)V", "defaultMenuItemColorsCached", "Landroidx/compose/material3/MenuItemColors;", "getDefaultMenuItemColorsCached$material3", "()Landroidx/compose/material3/MenuItemColors;", "setDefaultMenuItemColorsCached$material3", "(Landroidx/compose/material3/MenuItemColors;)V", "defaultNavigationBarItemColorsCached", "Landroidx/compose/material3/NavigationBarItemColors;", "getDefaultNavigationBarItemColorsCached$material3", "()Landroidx/compose/material3/NavigationBarItemColors;", "setDefaultNavigationBarItemColorsCached$material3", "(Landroidx/compose/material3/NavigationBarItemColors;)V", "defaultShortNavigationBarItemColorsCached", "Landroidx/compose/material3/NavigationItemColors;", "getDefaultShortNavigationBarItemColorsCached$material3", "()Landroidx/compose/material3/NavigationItemColors;", "setDefaultShortNavigationBarItemColorsCached$material3", "(Landroidx/compose/material3/NavigationItemColors;)V", "defaultNavigationRailItemColorsCached", "Landroidx/compose/material3/NavigationRailItemColors;", "getDefaultNavigationRailItemColorsCached$material3", "()Landroidx/compose/material3/NavigationRailItemColors;", "setDefaultNavigationRailItemColorsCached$material3", "(Landroidx/compose/material3/NavigationRailItemColors;)V", "defaultWideWideNavigationRailColorsCached", "Landroidx/compose/material3/WideNavigationRailColors;", "getDefaultWideWideNavigationRailColorsCached$material3", "()Landroidx/compose/material3/WideNavigationRailColors;", "setDefaultWideWideNavigationRailColorsCached$material3", "(Landroidx/compose/material3/WideNavigationRailColors;)V", "defaultWideNavigationRailItemColorsCached", "getDefaultWideNavigationRailItemColorsCached$material3", "setDefaultWideNavigationRailItemColorsCached$material3", "defaultRadioButtonColorsCached", "Landroidx/compose/material3/RadioButtonColors;", "getDefaultRadioButtonColorsCached$material3", "()Landroidx/compose/material3/RadioButtonColors;", "setDefaultRadioButtonColorsCached$material3", "(Landroidx/compose/material3/RadioButtonColors;)V", "defaultSegmentedButtonColorsCached", "Landroidx/compose/material3/SegmentedButtonColors;", "getDefaultSegmentedButtonColorsCached$material3", "()Landroidx/compose/material3/SegmentedButtonColors;", "setDefaultSegmentedButtonColorsCached$material3", "(Landroidx/compose/material3/SegmentedButtonColors;)V", "defaultSliderColorsCached", "Landroidx/compose/material3/SliderColors;", "getDefaultSliderColorsCached$material3", "()Landroidx/compose/material3/SliderColors;", "setDefaultSliderColorsCached$material3", "(Landroidx/compose/material3/SliderColors;)V", "defaultSwitchColorsCached", "Landroidx/compose/material3/SwitchColors;", "getDefaultSwitchColorsCached$material3", "()Landroidx/compose/material3/SwitchColors;", "setDefaultSwitchColorsCached$material3", "(Landroidx/compose/material3/SwitchColors;)V", "defaultOutlinedTextFieldColorsCached", "Landroidx/compose/material3/TextFieldColors;", "getDefaultOutlinedTextFieldColorsCached$material3", "()Landroidx/compose/material3/TextFieldColors;", "setDefaultOutlinedTextFieldColorsCached$material3", "(Landroidx/compose/material3/TextFieldColors;)V", "defaultTextFieldColorsCached", "getDefaultTextFieldColorsCached$material3", "setDefaultTextFieldColorsCached$material3", "defaultTimePickerColorsCached", "Landroidx/compose/material3/TimePickerColors;", "getDefaultTimePickerColorsCached$material3$annotations", "getDefaultTimePickerColorsCached$material3", "()Landroidx/compose/material3/TimePickerColors;", "setDefaultTimePickerColorsCached$material3", "(Landroidx/compose/material3/TimePickerColors;)V", "defaultRichTooltipColorsCached", "Landroidx/compose/material3/RichTooltipColors;", "getDefaultRichTooltipColorsCached$material3$annotations", "getDefaultRichTooltipColorsCached$material3", "()Landroidx/compose/material3/RichTooltipColors;", "setDefaultRichTooltipColorsCached$material3", "(Landroidx/compose/material3/RichTooltipColors;)V", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ColorScheme {
    public static final int $stable = 0;
    private final long background;
    private ChipColors defaultAssistChipColorsCached;
    private ButtonColors defaultButtonColorsCached;
    private CardColors defaultCardColorsCached;
    private CheckboxColors defaultCheckboxColorsCached;
    private DatePickerColors defaultDatePickerColorsCached;
    private ChipColors defaultElevatedAssistChipColorsCached;
    private ButtonColors defaultElevatedButtonColorsCached;
    private CardColors defaultElevatedCardColorsCached;
    private SelectableChipColors defaultElevatedFilterChipColorsCached;
    private ChipColors defaultElevatedSuggestionChipColorsCached;
    private IconButtonColors defaultFilledIconButtonColorsCached;
    private IconToggleButtonColors defaultFilledIconToggleButtonColorsCached;
    private ButtonColors defaultFilledTonalButtonColorsCached;
    private IconButtonColors defaultFilledTonalIconButtonColorsCached;
    private IconToggleButtonColors defaultFilledTonalIconToggleButtonColorsCached;
    private SelectableChipColors defaultFilterChipColorsCached;
    private IconButtonColors defaultIconButtonColorsCached;
    private IconButtonColors defaultIconButtonVibrantColorsCached;
    private IconToggleButtonColors defaultIconToggleButtonColorsCached;
    private IconToggleButtonColors defaultIconToggleButtonVibrantColorsCached;
    private SelectableChipColors defaultInputChipColorsCached;
    private ListItemColors defaultListItemColorsCached;
    private MenuItemColors defaultMenuItemColorsCached;
    private NavigationBarItemColors defaultNavigationBarItemColorsCached;
    private NavigationRailItemColors defaultNavigationRailItemColorsCached;
    private ButtonColors defaultOutlinedButtonColorsCached;
    private CardColors defaultOutlinedCardColorsCached;
    private IconButtonColors defaultOutlinedIconButtonColorsCached;
    private IconButtonColors defaultOutlinedIconButtonVibrantColorsCached;
    private IconToggleButtonColors defaultOutlinedIconToggleButtonColorsCached;
    private IconToggleButtonColors defaultOutlinedIconToggleButtonVibrantColorsCached;
    private TextFieldColors defaultOutlinedTextFieldColorsCached;
    private RadioButtonColors defaultRadioButtonColorsCached;
    private RichTooltipColors defaultRichTooltipColorsCached;
    private SegmentedButtonColors defaultSegmentedButtonColorsCached;
    private NavigationItemColors defaultShortNavigationBarItemColorsCached;
    private SliderColors defaultSliderColorsCached;
    private ChipColors defaultSuggestionChipColorsCached;
    private SwitchColors defaultSwitchColorsCached;
    private ButtonColors defaultTextButtonColorsCached;
    private TextFieldColors defaultTextFieldColorsCached;
    private TimePickerColors defaultTimePickerColorsCached;
    private TopAppBarColors defaultTopAppBarColorsCached;
    private DragHandleColors defaultVerticalDragHandleColorsCached;
    private NavigationItemColors defaultWideNavigationRailItemColorsCached;
    private WideNavigationRailColors defaultWideWideNavigationRailColorsCached;
    private final long error;
    private final long errorContainer;
    private final long inverseOnSurface;
    private final long inversePrimary;
    private final long inverseSurface;
    private final long onBackground;
    private final long onError;
    private final long onErrorContainer;
    private final long onPrimary;
    private final long onPrimaryContainer;
    private final long onPrimaryFixed;
    private final long onPrimaryFixedVariant;
    private final long onSecondary;
    private final long onSecondaryContainer;
    private final long onSecondaryFixed;
    private final long onSecondaryFixedVariant;
    private final long onSurface;
    private final long onSurfaceVariant;
    private final long onTertiary;
    private final long onTertiaryContainer;
    private final long onTertiaryFixed;
    private final long onTertiaryFixedVariant;
    private final long outline;
    private final long outlineVariant;
    private final long primary;
    private final long primaryContainer;
    private final long primaryFixed;
    private final long primaryFixedDim;
    private final long scrim;
    private final long secondary;
    private final long secondaryContainer;
    private final long secondaryFixed;
    private final long secondaryFixedDim;
    private final long surface;
    private final long surfaceBright;
    private final long surfaceContainer;
    private final long surfaceContainerHigh;
    private final long surfaceContainerHighest;
    private final long surfaceContainerLow;
    private final long surfaceContainerLowest;
    private final long surfaceDim;
    private final long surfaceTint;
    private final long surfaceVariant;
    private final long tertiary;
    private final long tertiaryContainer;
    private final long tertiaryFixed;
    private final long tertiaryFixedDim;

    public /* synthetic */ ColorScheme(long r1, long r3, long r5, long r7, long r9, long r11, long r13, long r15, long r17, long r19, long r21, long r23, long r25, long r27, long r29, long r31, long r33, long r35, long r37, long r39, long r41, long r43, long r45, long r47, long r49, long r51, long r53, long r55, long r57, long r59, long r61, long r63, long r65, long r67, long r69, long r71, long r73, long r75, long r77, long r79, long r81, long r83, long r85, long r87, long r89, long r91, long r93, long r95, DefaultConstructorMarker r97) {
        this(r1, r3, r5, r7, r9, r11, r13, r15, r17, r19, r21, r23, r25, r27, r29, r31, r33, r35, r37, r39, r41, r43, r45, r47, r49, r51, r53, r55, r57, r59, r61, r63, r65, r67, r69, r71, r73, r75, r77, r79, r81, r83, r85, r87, r89, r91, r93, r95);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Use constructor with additional 'fixed' container roles.", replaceWith = @ReplaceWith(expression = "ColorScheme(primary,\nonPrimary,\nprimaryContainer,\nonPrimaryContainer,\ninversePrimary,\nsecondary,\nonSecondary,\nsecondaryContainer,\nonSecondaryContainer,\ntertiary,\nonTertiary,\ntertiaryContainer,\nonTertiaryContainer,\nbackground,\nonBackground,\nsurface,\nonSurface,\nsurfaceVariant,\nonSurfaceVariant,\nsurfaceTint,\ninverseSurface,\ninverseOnSurface,\nerror,\nonError,\nerrorContainer,\nonErrorContainer,\noutline,\noutlineVariant,\nscrim,\nsurfaceBright,\nsurfaceDim,\nsurfaceContainer,\nsurfaceContainerHigh,\nsurfaceContainerHighest,\nsurfaceContainerLow,\nsurfaceContainerLowest,)", imports = {}))
    public /* synthetic */ ColorScheme(long r1, long r3, long r5, long r7, long r9, long r11, long r13, long r15, long r17, long r19, long r21, long r23, long r25, long r27, long r29, long r31, long r33, long r35, long r37, long r39, long r41, long r43, long r45, long r47, long r49, long r51, long r53, long r55, long r57, long r59, long r61, long r63, long r65, long r67, long r69, long r71, DefaultConstructorMarker r73) {
        this(r1, r3, r5, r7, r9, r11, r13, r15, r17, r19, r21, r23, r25, r27, r29, r31, r33, r35, r37, r39, r41, r43, r45, r47, r49, r51, r53, r55, r57, r59, r61, r63, r65, r67, r69, r71);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Use constructor with additional 'surfaceContainer' roles.", replaceWith = @ReplaceWith(expression = "ColorScheme(primary,\nonPrimary,\nprimaryContainer,\nonPrimaryContainer,\ninversePrimary,\nsecondary,\nonSecondary,\nsecondaryContainer,\nonSecondaryContainer,\ntertiary,\nonTertiary,\ntertiaryContainer,\nonTertiaryContainer,\nbackground,\nonBackground,\nsurface,\nonSurface,\nsurfaceVariant,\nonSurfaceVariant,\nsurfaceTint,\ninverseSurface,\ninverseOnSurface,\nerror,\nonError,\nerrorContainer,\nonErrorContainer,\noutline,\noutlineVariant,\nscrim,\nsurfaceBright,\nsurfaceDim,\nsurfaceContainer,\nsurfaceContainerHigh,\nsurfaceContainerHighest,\nsurfaceContainerLow,\nsurfaceContainerLowest,\nprimaryFixed,\nprimaryFixedDim,\nonPrimaryFixed,\nonPrimaryFixedVariant,\nsecondaryFixed,\nsecondaryFixedDim,\nonSecondaryFixed,\nonSecondaryFixedVariant,\ntertiaryFixed,\ntertiaryFixedDim,\nonTertiaryFixed,\nonTertiaryFixedVariant)", imports = {}))
    public /* synthetic */ ColorScheme(long r1, long r3, long r5, long r7, long r9, long r11, long r13, long r15, long r17, long r19, long r21, long r23, long r25, long r27, long r29, long r31, long r33, long r35, long r37, long r39, long r41, long r43, long r45, long r47, long r49, long r51, long r53, long r55, long r57, DefaultConstructorMarker r59) {
        this(r1, r3, r5, r7, r9, r11, r13, r15, r17, r19, r21, r23, r25, r27, r29, r31, r33, r35, r37, r39, r41, r43, r45, r47, r49, r51, r53, r55, r57);
    }

    public static /* synthetic */ void getDefaultDatePickerColorsCached$material3$annotations() {
    }

    public static /* synthetic */ void getDefaultRichTooltipColorsCached$material3$annotations() {
    }

    public static /* synthetic */ void getDefaultTimePickerColorsCached$material3$annotations() {
    }

    public static /* synthetic */ void getDefaultTopAppBarColorsCached$material3$annotations() {
    }

    public String toString() {
        return "ColorScheme(primary=" + Color.toString-impl(this.primary) + "onPrimary=" + Color.toString-impl(this.onPrimary) + "primaryContainer=" + Color.toString-impl(this.primaryContainer) + "onPrimaryContainer=" + Color.toString-impl(this.onPrimaryContainer) + "inversePrimary=" + Color.toString-impl(this.inversePrimary) + "secondary=" + Color.toString-impl(this.secondary) + "onSecondary=" + Color.toString-impl(this.onSecondary) + "secondaryContainer=" + Color.toString-impl(this.secondaryContainer) + "onSecondaryContainer=" + Color.toString-impl(this.onSecondaryContainer) + "tertiary=" + Color.toString-impl(this.tertiary) + "onTertiary=" + Color.toString-impl(this.onTertiary) + "tertiaryContainer=" + Color.toString-impl(this.tertiaryContainer) + "onTertiaryContainer=" + Color.toString-impl(this.onTertiaryContainer) + "background=" + Color.toString-impl(this.background) + "onBackground=" + Color.toString-impl(this.onBackground) + "surface=" + Color.toString-impl(this.surface) + "onSurface=" + Color.toString-impl(this.onSurface) + "surfaceVariant=" + Color.toString-impl(this.surfaceVariant) + "onSurfaceVariant=" + Color.toString-impl(this.onSurfaceVariant) + "surfaceTint=" + Color.toString-impl(this.surfaceTint) + "inverseSurface=" + Color.toString-impl(this.inverseSurface) + "inverseOnSurface=" + Color.toString-impl(this.inverseOnSurface) + "error=" + Color.toString-impl(this.error) + "onError=" + Color.toString-impl(this.onError) + "errorContainer=" + Color.toString-impl(this.errorContainer) + "onErrorContainer=" + Color.toString-impl(this.onErrorContainer) + "outline=" + Color.toString-impl(this.outline) + "outlineVariant=" + Color.toString-impl(this.outlineVariant) + "scrim=" + Color.toString-impl(this.scrim) + "surfaceBright=" + Color.toString-impl(this.surfaceBright) + "surfaceDim=" + Color.toString-impl(this.surfaceDim) + "surfaceContainer=" + Color.toString-impl(this.surfaceContainer) + "surfaceContainerHigh=" + Color.toString-impl(this.surfaceContainerHigh) + "surfaceContainerHighest=" + Color.toString-impl(this.surfaceContainerHighest) + "surfaceContainerLow=" + Color.toString-impl(this.surfaceContainerLow) + "surfaceContainerLowest=" + Color.toString-impl(this.surfaceContainerLowest) + "primaryFixed=" + Color.toString-impl(this.primaryFixed) + "primaryFixedDim=" + Color.toString-impl(this.primaryFixedDim) + "onPrimaryFixed=" + Color.toString-impl(this.onPrimaryContainer) + "onPrimaryFixedVariant=" + Color.toString-impl(this.onPrimaryFixedVariant) + "secondaryFixed=" + Color.toString-impl(this.secondaryFixed) + "secondaryFixedDim=" + Color.toString-impl(this.secondaryFixedDim) + "onSecondaryFixed=" + Color.toString-impl(this.onSecondaryFixed) + "onSecondaryFixedVariant=" + Color.toString-impl(this.onSecondaryFixedVariant) + "tertiaryFixed=" + Color.toString-impl(this.tertiaryFixed) + "tertiaryFixedDim=" + Color.toString-impl(this.tertiaryFixedDim) + "onTertiaryFixed=" + Color.toString-impl(this.onTertiaryFixed) + "onTertiaryFixedVariant=" + Color.toString-impl(this.onTertiaryFixedVariant) + ')';
    }

    /* JADX INFO: renamed from: getBackground-0d7_KjU, reason: not valid java name */
    public final long m2446getBackground0d7_KjU() {
        return this.background;
    }

    public final ChipColors getDefaultAssistChipColorsCached$material3() {
        return this.defaultAssistChipColorsCached;
    }

    public final ButtonColors getDefaultButtonColorsCached$material3() {
        return this.defaultButtonColorsCached;
    }

    public final CardColors getDefaultCardColorsCached$material3() {
        return this.defaultCardColorsCached;
    }

    public final CheckboxColors getDefaultCheckboxColorsCached$material3() {
        return this.defaultCheckboxColorsCached;
    }

    public final DatePickerColors getDefaultDatePickerColorsCached$material3() {
        return this.defaultDatePickerColorsCached;
    }

    public final ChipColors getDefaultElevatedAssistChipColorsCached$material3() {
        return this.defaultElevatedAssistChipColorsCached;
    }

    public final ButtonColors getDefaultElevatedButtonColorsCached$material3() {
        return this.defaultElevatedButtonColorsCached;
    }

    public final CardColors getDefaultElevatedCardColorsCached$material3() {
        return this.defaultElevatedCardColorsCached;
    }

    public final SelectableChipColors getDefaultElevatedFilterChipColorsCached$material3() {
        return this.defaultElevatedFilterChipColorsCached;
    }

    public final ChipColors getDefaultElevatedSuggestionChipColorsCached$material3() {
        return this.defaultElevatedSuggestionChipColorsCached;
    }

    public final IconButtonColors getDefaultFilledIconButtonColorsCached$material3() {
        return this.defaultFilledIconButtonColorsCached;
    }

    public final IconToggleButtonColors getDefaultFilledIconToggleButtonColorsCached$material3() {
        return this.defaultFilledIconToggleButtonColorsCached;
    }

    public final ButtonColors getDefaultFilledTonalButtonColorsCached$material3() {
        return this.defaultFilledTonalButtonColorsCached;
    }

    public final IconButtonColors getDefaultFilledTonalIconButtonColorsCached$material3() {
        return this.defaultFilledTonalIconButtonColorsCached;
    }

    public final IconToggleButtonColors getDefaultFilledTonalIconToggleButtonColorsCached$material3() {
        return this.defaultFilledTonalIconToggleButtonColorsCached;
    }

    public final SelectableChipColors getDefaultFilterChipColorsCached$material3() {
        return this.defaultFilterChipColorsCached;
    }

    public final IconButtonColors getDefaultIconButtonColorsCached$material3() {
        return this.defaultIconButtonColorsCached;
    }

    public final IconButtonColors getDefaultIconButtonVibrantColorsCached$material3() {
        return this.defaultIconButtonVibrantColorsCached;
    }

    public final IconToggleButtonColors getDefaultIconToggleButtonColorsCached$material3() {
        return this.defaultIconToggleButtonColorsCached;
    }

    public final IconToggleButtonColors getDefaultIconToggleButtonVibrantColorsCached$material3() {
        return this.defaultIconToggleButtonVibrantColorsCached;
    }

    public final SelectableChipColors getDefaultInputChipColorsCached$material3() {
        return this.defaultInputChipColorsCached;
    }

    public final ListItemColors getDefaultListItemColorsCached$material3() {
        return this.defaultListItemColorsCached;
    }

    public final MenuItemColors getDefaultMenuItemColorsCached$material3() {
        return this.defaultMenuItemColorsCached;
    }

    public final NavigationBarItemColors getDefaultNavigationBarItemColorsCached$material3() {
        return this.defaultNavigationBarItemColorsCached;
    }

    public final NavigationRailItemColors getDefaultNavigationRailItemColorsCached$material3() {
        return this.defaultNavigationRailItemColorsCached;
    }

    public final ButtonColors getDefaultOutlinedButtonColorsCached$material3() {
        return this.defaultOutlinedButtonColorsCached;
    }

    public final CardColors getDefaultOutlinedCardColorsCached$material3() {
        return this.defaultOutlinedCardColorsCached;
    }

    public final IconButtonColors getDefaultOutlinedIconButtonColorsCached$material3() {
        return this.defaultOutlinedIconButtonColorsCached;
    }

    public final IconButtonColors getDefaultOutlinedIconButtonVibrantColorsCached$material3() {
        return this.defaultOutlinedIconButtonVibrantColorsCached;
    }

    public final IconToggleButtonColors getDefaultOutlinedIconToggleButtonColorsCached$material3() {
        return this.defaultOutlinedIconToggleButtonColorsCached;
    }

    public final IconToggleButtonColors getDefaultOutlinedIconToggleButtonVibrantColorsCached$material3() {
        return this.defaultOutlinedIconToggleButtonVibrantColorsCached;
    }

    public final TextFieldColors getDefaultOutlinedTextFieldColorsCached$material3() {
        return this.defaultOutlinedTextFieldColorsCached;
    }

    public final RadioButtonColors getDefaultRadioButtonColorsCached$material3() {
        return this.defaultRadioButtonColorsCached;
    }

    public final RichTooltipColors getDefaultRichTooltipColorsCached$material3() {
        return this.defaultRichTooltipColorsCached;
    }

    public final SegmentedButtonColors getDefaultSegmentedButtonColorsCached$material3() {
        return this.defaultSegmentedButtonColorsCached;
    }

    public final NavigationItemColors getDefaultShortNavigationBarItemColorsCached$material3() {
        return this.defaultShortNavigationBarItemColorsCached;
    }

    public final SliderColors getDefaultSliderColorsCached$material3() {
        return this.defaultSliderColorsCached;
    }

    public final ChipColors getDefaultSuggestionChipColorsCached$material3() {
        return this.defaultSuggestionChipColorsCached;
    }

    public final SwitchColors getDefaultSwitchColorsCached$material3() {
        return this.defaultSwitchColorsCached;
    }

    public final ButtonColors getDefaultTextButtonColorsCached$material3() {
        return this.defaultTextButtonColorsCached;
    }

    public final TextFieldColors getDefaultTextFieldColorsCached$material3() {
        return this.defaultTextFieldColorsCached;
    }

    public final TimePickerColors getDefaultTimePickerColorsCached$material3() {
        return this.defaultTimePickerColorsCached;
    }

    public final TopAppBarColors getDefaultTopAppBarColorsCached$material3() {
        return this.defaultTopAppBarColorsCached;
    }

    public final DragHandleColors getDefaultVerticalDragHandleColorsCached$material3() {
        return this.defaultVerticalDragHandleColorsCached;
    }

    public final NavigationItemColors getDefaultWideNavigationRailItemColorsCached$material3() {
        return this.defaultWideNavigationRailItemColorsCached;
    }

    public final WideNavigationRailColors getDefaultWideWideNavigationRailColorsCached$material3() {
        return this.defaultWideWideNavigationRailColorsCached;
    }

    /* JADX INFO: renamed from: getError-0d7_KjU, reason: not valid java name */
    public final long m2447getError0d7_KjU() {
        return this.error;
    }

    /* JADX INFO: renamed from: getErrorContainer-0d7_KjU, reason: not valid java name */
    public final long m2448getErrorContainer0d7_KjU() {
        return this.errorContainer;
    }

    /* JADX INFO: renamed from: getInverseOnSurface-0d7_KjU, reason: not valid java name */
    public final long m2449getInverseOnSurface0d7_KjU() {
        return this.inverseOnSurface;
    }

    /* JADX INFO: renamed from: getInversePrimary-0d7_KjU, reason: not valid java name */
    public final long m2450getInversePrimary0d7_KjU() {
        return this.inversePrimary;
    }

    /* JADX INFO: renamed from: getInverseSurface-0d7_KjU, reason: not valid java name */
    public final long m2451getInverseSurface0d7_KjU() {
        return this.inverseSurface;
    }

    /* JADX INFO: renamed from: getOnBackground-0d7_KjU, reason: not valid java name */
    public final long m2452getOnBackground0d7_KjU() {
        return this.onBackground;
    }

    /* JADX INFO: renamed from: getOnError-0d7_KjU, reason: not valid java name */
    public final long m2453getOnError0d7_KjU() {
        return this.onError;
    }

    /* JADX INFO: renamed from: getOnErrorContainer-0d7_KjU, reason: not valid java name */
    public final long m2454getOnErrorContainer0d7_KjU() {
        return this.onErrorContainer;
    }

    /* JADX INFO: renamed from: getOnPrimary-0d7_KjU, reason: not valid java name */
    public final long m2455getOnPrimary0d7_KjU() {
        return this.onPrimary;
    }

    /* JADX INFO: renamed from: getOnPrimaryContainer-0d7_KjU, reason: not valid java name */
    public final long m2456getOnPrimaryContainer0d7_KjU() {
        return this.onPrimaryContainer;
    }

    /* JADX INFO: renamed from: getOnPrimaryFixed-0d7_KjU, reason: not valid java name */
    public final long m2457getOnPrimaryFixed0d7_KjU() {
        return this.onPrimaryFixed;
    }

    /* JADX INFO: renamed from: getOnPrimaryFixedVariant-0d7_KjU, reason: not valid java name */
    public final long m2458getOnPrimaryFixedVariant0d7_KjU() {
        return this.onPrimaryFixedVariant;
    }

    /* JADX INFO: renamed from: getOnSecondary-0d7_KjU, reason: not valid java name */
    public final long m2459getOnSecondary0d7_KjU() {
        return this.onSecondary;
    }

    /* JADX INFO: renamed from: getOnSecondaryContainer-0d7_KjU, reason: not valid java name */
    public final long m2460getOnSecondaryContainer0d7_KjU() {
        return this.onSecondaryContainer;
    }

    /* JADX INFO: renamed from: getOnSecondaryFixed-0d7_KjU, reason: not valid java name */
    public final long m2461getOnSecondaryFixed0d7_KjU() {
        return this.onSecondaryFixed;
    }

    /* JADX INFO: renamed from: getOnSecondaryFixedVariant-0d7_KjU, reason: not valid java name */
    public final long m2462getOnSecondaryFixedVariant0d7_KjU() {
        return this.onSecondaryFixedVariant;
    }

    /* JADX INFO: renamed from: getOnSurface-0d7_KjU, reason: not valid java name */
    public final long m2463getOnSurface0d7_KjU() {
        return this.onSurface;
    }

    /* JADX INFO: renamed from: getOnSurfaceVariant-0d7_KjU, reason: not valid java name */
    public final long m2464getOnSurfaceVariant0d7_KjU() {
        return this.onSurfaceVariant;
    }

    /* JADX INFO: renamed from: getOnTertiary-0d7_KjU, reason: not valid java name */
    public final long m2465getOnTertiary0d7_KjU() {
        return this.onTertiary;
    }

    /* JADX INFO: renamed from: getOnTertiaryContainer-0d7_KjU, reason: not valid java name */
    public final long m2466getOnTertiaryContainer0d7_KjU() {
        return this.onTertiaryContainer;
    }

    /* JADX INFO: renamed from: getOnTertiaryFixed-0d7_KjU, reason: not valid java name */
    public final long m2467getOnTertiaryFixed0d7_KjU() {
        return this.onTertiaryFixed;
    }

    /* JADX INFO: renamed from: getOnTertiaryFixedVariant-0d7_KjU, reason: not valid java name */
    public final long m2468getOnTertiaryFixedVariant0d7_KjU() {
        return this.onTertiaryFixedVariant;
    }

    /* JADX INFO: renamed from: getOutline-0d7_KjU, reason: not valid java name */
    public final long m2469getOutline0d7_KjU() {
        return this.outline;
    }

    /* JADX INFO: renamed from: getOutlineVariant-0d7_KjU, reason: not valid java name */
    public final long m2470getOutlineVariant0d7_KjU() {
        return this.outlineVariant;
    }

    /* JADX INFO: renamed from: getPrimary-0d7_KjU, reason: not valid java name */
    public final long m2471getPrimary0d7_KjU() {
        return this.primary;
    }

    /* JADX INFO: renamed from: getPrimaryContainer-0d7_KjU, reason: not valid java name */
    public final long m2472getPrimaryContainer0d7_KjU() {
        return this.primaryContainer;
    }

    /* JADX INFO: renamed from: getPrimaryFixed-0d7_KjU, reason: not valid java name */
    public final long m2473getPrimaryFixed0d7_KjU() {
        return this.primaryFixed;
    }

    /* JADX INFO: renamed from: getPrimaryFixedDim-0d7_KjU, reason: not valid java name */
    public final long m2474getPrimaryFixedDim0d7_KjU() {
        return this.primaryFixedDim;
    }

    /* JADX INFO: renamed from: getScrim-0d7_KjU, reason: not valid java name */
    public final long m2475getScrim0d7_KjU() {
        return this.scrim;
    }

    /* JADX INFO: renamed from: getSecondary-0d7_KjU, reason: not valid java name */
    public final long m2476getSecondary0d7_KjU() {
        return this.secondary;
    }

    /* JADX INFO: renamed from: getSecondaryContainer-0d7_KjU, reason: not valid java name */
    public final long m2477getSecondaryContainer0d7_KjU() {
        return this.secondaryContainer;
    }

    /* JADX INFO: renamed from: getSecondaryFixed-0d7_KjU, reason: not valid java name */
    public final long m2478getSecondaryFixed0d7_KjU() {
        return this.secondaryFixed;
    }

    /* JADX INFO: renamed from: getSecondaryFixedDim-0d7_KjU, reason: not valid java name */
    public final long m2479getSecondaryFixedDim0d7_KjU() {
        return this.secondaryFixedDim;
    }

    /* JADX INFO: renamed from: getSurface-0d7_KjU, reason: not valid java name */
    public final long m2480getSurface0d7_KjU() {
        return this.surface;
    }

    /* JADX INFO: renamed from: getSurfaceBright-0d7_KjU, reason: not valid java name */
    public final long m2481getSurfaceBright0d7_KjU() {
        return this.surfaceBright;
    }

    /* JADX INFO: renamed from: getSurfaceContainer-0d7_KjU, reason: not valid java name */
    public final long m2482getSurfaceContainer0d7_KjU() {
        return this.surfaceContainer;
    }

    /* JADX INFO: renamed from: getSurfaceContainerHigh-0d7_KjU, reason: not valid java name */
    public final long m2483getSurfaceContainerHigh0d7_KjU() {
        return this.surfaceContainerHigh;
    }

    /* JADX INFO: renamed from: getSurfaceContainerHighest-0d7_KjU, reason: not valid java name */
    public final long m2484getSurfaceContainerHighest0d7_KjU() {
        return this.surfaceContainerHighest;
    }

    /* JADX INFO: renamed from: getSurfaceContainerLow-0d7_KjU, reason: not valid java name */
    public final long m2485getSurfaceContainerLow0d7_KjU() {
        return this.surfaceContainerLow;
    }

    /* JADX INFO: renamed from: getSurfaceContainerLowest-0d7_KjU, reason: not valid java name */
    public final long m2486getSurfaceContainerLowest0d7_KjU() {
        return this.surfaceContainerLowest;
    }

    /* JADX INFO: renamed from: getSurfaceDim-0d7_KjU, reason: not valid java name */
    public final long m2487getSurfaceDim0d7_KjU() {
        return this.surfaceDim;
    }

    /* JADX INFO: renamed from: getSurfaceTint-0d7_KjU, reason: not valid java name */
    public final long m2488getSurfaceTint0d7_KjU() {
        return this.surfaceTint;
    }

    /* JADX INFO: renamed from: getSurfaceVariant-0d7_KjU, reason: not valid java name */
    public final long m2489getSurfaceVariant0d7_KjU() {
        return this.surfaceVariant;
    }

    /* JADX INFO: renamed from: getTertiary-0d7_KjU, reason: not valid java name */
    public final long m2490getTertiary0d7_KjU() {
        return this.tertiary;
    }

    /* JADX INFO: renamed from: getTertiaryContainer-0d7_KjU, reason: not valid java name */
    public final long m2491getTertiaryContainer0d7_KjU() {
        return this.tertiaryContainer;
    }

    /* JADX INFO: renamed from: getTertiaryFixed-0d7_KjU, reason: not valid java name */
    public final long m2492getTertiaryFixed0d7_KjU() {
        return this.tertiaryFixed;
    }

    /* JADX INFO: renamed from: getTertiaryFixedDim-0d7_KjU, reason: not valid java name */
    public final long m2493getTertiaryFixedDim0d7_KjU() {
        return this.tertiaryFixedDim;
    }

    public final void setDefaultAssistChipColorsCached$material3(ChipColors r1) {
        this.defaultAssistChipColorsCached = r1;
    }

    public final void setDefaultButtonColorsCached$material3(ButtonColors r1) {
        this.defaultButtonColorsCached = r1;
    }

    public final void setDefaultCardColorsCached$material3(CardColors r1) {
        this.defaultCardColorsCached = r1;
    }

    public final void setDefaultCheckboxColorsCached$material3(CheckboxColors r1) {
        this.defaultCheckboxColorsCached = r1;
    }

    public final void setDefaultDatePickerColorsCached$material3(DatePickerColors r1) {
        this.defaultDatePickerColorsCached = r1;
    }

    public final void setDefaultElevatedAssistChipColorsCached$material3(ChipColors r1) {
        this.defaultElevatedAssistChipColorsCached = r1;
    }

    public final void setDefaultElevatedButtonColorsCached$material3(ButtonColors r1) {
        this.defaultElevatedButtonColorsCached = r1;
    }

    public final void setDefaultElevatedCardColorsCached$material3(CardColors r1) {
        this.defaultElevatedCardColorsCached = r1;
    }

    public final void setDefaultElevatedFilterChipColorsCached$material3(SelectableChipColors r1) {
        this.defaultElevatedFilterChipColorsCached = r1;
    }

    public final void setDefaultElevatedSuggestionChipColorsCached$material3(ChipColors r1) {
        this.defaultElevatedSuggestionChipColorsCached = r1;
    }

    public final void setDefaultFilledIconButtonColorsCached$material3(IconButtonColors r1) {
        this.defaultFilledIconButtonColorsCached = r1;
    }

    public final void setDefaultFilledIconToggleButtonColorsCached$material3(IconToggleButtonColors r1) {
        this.defaultFilledIconToggleButtonColorsCached = r1;
    }

    public final void setDefaultFilledTonalButtonColorsCached$material3(ButtonColors r1) {
        this.defaultFilledTonalButtonColorsCached = r1;
    }

    public final void setDefaultFilledTonalIconButtonColorsCached$material3(IconButtonColors r1) {
        this.defaultFilledTonalIconButtonColorsCached = r1;
    }

    public final void setDefaultFilledTonalIconToggleButtonColorsCached$material3(IconToggleButtonColors r1) {
        this.defaultFilledTonalIconToggleButtonColorsCached = r1;
    }

    public final void setDefaultFilterChipColorsCached$material3(SelectableChipColors r1) {
        this.defaultFilterChipColorsCached = r1;
    }

    public final void setDefaultIconButtonColorsCached$material3(IconButtonColors r1) {
        this.defaultIconButtonColorsCached = r1;
    }

    public final void setDefaultIconButtonVibrantColorsCached$material3(IconButtonColors r1) {
        this.defaultIconButtonVibrantColorsCached = r1;
    }

    public final void setDefaultIconToggleButtonColorsCached$material3(IconToggleButtonColors r1) {
        this.defaultIconToggleButtonColorsCached = r1;
    }

    public final void setDefaultIconToggleButtonVibrantColorsCached$material3(IconToggleButtonColors r1) {
        this.defaultIconToggleButtonVibrantColorsCached = r1;
    }

    public final void setDefaultInputChipColorsCached$material3(SelectableChipColors r1) {
        this.defaultInputChipColorsCached = r1;
    }

    public final void setDefaultListItemColorsCached$material3(ListItemColors r1) {
        this.defaultListItemColorsCached = r1;
    }

    public final void setDefaultMenuItemColorsCached$material3(MenuItemColors r1) {
        this.defaultMenuItemColorsCached = r1;
    }

    public final void setDefaultNavigationBarItemColorsCached$material3(NavigationBarItemColors r1) {
        this.defaultNavigationBarItemColorsCached = r1;
    }

    public final void setDefaultNavigationRailItemColorsCached$material3(NavigationRailItemColors r1) {
        this.defaultNavigationRailItemColorsCached = r1;
    }

    public final void setDefaultOutlinedButtonColorsCached$material3(ButtonColors r1) {
        this.defaultOutlinedButtonColorsCached = r1;
    }

    public final void setDefaultOutlinedCardColorsCached$material3(CardColors r1) {
        this.defaultOutlinedCardColorsCached = r1;
    }

    public final void setDefaultOutlinedIconButtonColorsCached$material3(IconButtonColors r1) {
        this.defaultOutlinedIconButtonColorsCached = r1;
    }

    public final void setDefaultOutlinedIconButtonVibrantColorsCached$material3(IconButtonColors r1) {
        this.defaultOutlinedIconButtonVibrantColorsCached = r1;
    }

    public final void setDefaultOutlinedIconToggleButtonColorsCached$material3(IconToggleButtonColors r1) {
        this.defaultOutlinedIconToggleButtonColorsCached = r1;
    }

    public final void setDefaultOutlinedIconToggleButtonVibrantColorsCached$material3(IconToggleButtonColors r1) {
        this.defaultOutlinedIconToggleButtonVibrantColorsCached = r1;
    }

    public final void setDefaultOutlinedTextFieldColorsCached$material3(TextFieldColors r1) {
        this.defaultOutlinedTextFieldColorsCached = r1;
    }

    public final void setDefaultRadioButtonColorsCached$material3(RadioButtonColors r1) {
        this.defaultRadioButtonColorsCached = r1;
    }

    public final void setDefaultRichTooltipColorsCached$material3(RichTooltipColors r1) {
        this.defaultRichTooltipColorsCached = r1;
    }

    public final void setDefaultSegmentedButtonColorsCached$material3(SegmentedButtonColors r1) {
        this.defaultSegmentedButtonColorsCached = r1;
    }

    public final void setDefaultShortNavigationBarItemColorsCached$material3(NavigationItemColors r1) {
        this.defaultShortNavigationBarItemColorsCached = r1;
    }

    public final void setDefaultSliderColorsCached$material3(SliderColors r1) {
        this.defaultSliderColorsCached = r1;
    }

    public final void setDefaultSuggestionChipColorsCached$material3(ChipColors r1) {
        this.defaultSuggestionChipColorsCached = r1;
    }

    public final void setDefaultSwitchColorsCached$material3(SwitchColors r1) {
        this.defaultSwitchColorsCached = r1;
    }

    public final void setDefaultTextButtonColorsCached$material3(ButtonColors r1) {
        this.defaultTextButtonColorsCached = r1;
    }

    public final void setDefaultTextFieldColorsCached$material3(TextFieldColors r1) {
        this.defaultTextFieldColorsCached = r1;
    }

    public final void setDefaultTimePickerColorsCached$material3(TimePickerColors r1) {
        this.defaultTimePickerColorsCached = r1;
    }

    public final void setDefaultTopAppBarColorsCached$material3(TopAppBarColors r1) {
        this.defaultTopAppBarColorsCached = r1;
    }

    public final void setDefaultVerticalDragHandleColorsCached$material3(DragHandleColors r1) {
        this.defaultVerticalDragHandleColorsCached = r1;
    }

    public final void setDefaultWideNavigationRailItemColorsCached$material3(NavigationItemColors r1) {
        this.defaultWideNavigationRailItemColorsCached = r1;
    }

    public final void setDefaultWideWideNavigationRailColorsCached$material3(WideNavigationRailColors r1) {
        this.defaultWideWideNavigationRailColorsCached = r1;
    }

    private ColorScheme(long r99, long r101, long r103, long r105, long r107, long r109, long r111, long r113, long r115, long r117, long r119, long r121, long r123, long r125, long r127, long r129, long r131, long r133, long r135, long r137, long r139, long r141, long r143, long r145, long r147, long r149, long r151, long r153, long r155) {
        Color.Companion r95 = Color.Companion;
        this(r99, r101, r103, r105, r107, r109, r111, r113, r115, r117, r119, r121, r123, r125, r127, r129, r131, r133, r135, r137, r139, r141, r143, r145, r147, r149, r151, r153, r155, r95.getUnspecified-0d7_KjU(), r95.getUnspecified-0d7_KjU(), r95.getUnspecified-0d7_KjU(), r95.getUnspecified-0d7_KjU(), r95.getUnspecified-0d7_KjU(), r95.getUnspecified-0d7_KjU(), r95.getUnspecified-0d7_KjU(), r95.getUnspecified-0d7_KjU(), r95.getUnspecified-0d7_KjU(), r95.getUnspecified-0d7_KjU(), r95.getUnspecified-0d7_KjU(), r95.getUnspecified-0d7_KjU(), r95.getUnspecified-0d7_KjU(), r95.getUnspecified-0d7_KjU(), r95.getUnspecified-0d7_KjU(), r95.getUnspecified-0d7_KjU(), r95.getUnspecified-0d7_KjU(), r95.getUnspecified-0d7_KjU(), r95.getUnspecified-0d7_KjU(), null);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility. Use overload with additional fixed roles instead")
    /* JADX INFO: renamed from: copy-G1PFc-w, reason: not valid java name */
    public final /* synthetic */ ColorScheme m2444copyG1PFcw(long r101, long r103, long r105, long r107, long r109, long r111, long r113, long r115, long r117, long r119, long r121, long r123, long r125, long r127, long r129, long r131, long r133, long r135, long r137, long r139, long r141, long r143, long r145, long r147, long r149, long r151, long r153, long r155, long r157) {
        return m2442copy_VG5OTI$default(this, r101, r103, r105, r107, r109, r111, r113, r115, r117, r119, r121, r123, r125, r127, r129, r131, r133, r135, r137, r139, r141, r143, r145, r147, r149, r151, r153, r155, r157, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -536870912, 65535, null);
    }

    /* JADX INFO: renamed from: copy-G1PFc-w$default, reason: not valid java name */
    public static /* synthetic */ ColorScheme m2441copyG1PFcw$default(ColorScheme r17, long r18, long r20, long r22, long r24, long r26, long r28, long r30, long r32, long r34, long r36, long r38, long r40, long r42, long r44, long r46, long r48, long r50, long r52, long r54, long r56, long r58, long r60, long r62, long r64, long r66, long r68, long r70, long r72, long r74, int r76, Object r77) {
        if ((r76 & 1) == 0) goto L5;
        long r2 = r17.primary;
    L7:
        if ((r76 & 2) == 0) goto L9;
        long r4 = r17.onPrimary;
    L11:
        if ((r76 & 4) == 0) goto L13;
        long r6 = r17.primaryContainer;
    L15:
        if ((r76 & 8) == 0) goto L17;
        long r8 = r17.onPrimaryContainer;
    L19:
        if ((r76 & 16) == 0) goto L21;
        long r10 = r17.inversePrimary;
    L23:
        if ((r76 & 32) == 0) goto L25;
        long r12 = r17.secondary;
    L27:
        if ((r76 & 64) == 0) goto L29;
        long r14 = r17.onSecondary;
    L30:
        long r31 = r14;
        if ((r76 & 128) == 0) goto L33;
        long r15 = r17.secondaryContainer;
    L34:
        long r33 = r15;
        if ((r76 & 256) == 0) goto L37;
        long r16 = r17.onSecondaryContainer;
    L38:
        long r35 = r16;
        if ((r76 & 512) == 0) goto L41;
        long r19 = r17.tertiary;
    L42:
        long r37 = r19;
        if ((r76 & 1024) == 0) goto L45;
        long r110 = r17.onTertiary;
    L46:
        long r39 = r110;
        if ((r76 & 2048) == 0) goto L49;
        long r111 = r17.tertiaryContainer;
    L50:
        long r41 = r111;
        if ((r76 & 4096) == 0) goto L53;
        long r112 = r17.onTertiaryContainer;
    L54:
        long r43 = r112;
        if ((r76 & 8192) == 0) goto L57;
        long r113 = r17.background;
    L58:
        long r45 = r113;
        if ((r76 & 16384) == 0) goto L61;
        long r114 = r17.onBackground;
    L62:
        long r47 = r114;
        if ((r76 & BiometricManager$Authenticators.DEVICE_CREDENTIAL) == 0) goto L65;
        long r115 = r17.surface;
    L66:
        long r49 = r115;
        if ((r76 & 65536) == 0) goto L69;
        long r116 = r17.onSurface;
    L70:
        long r51 = r116;
        if ((r76 & 131072) == 0) goto L73;
        long r117 = r17.surfaceVariant;
    L74:
        long r53 = r117;
        if ((r76 & 262144) == 0) goto L77;
        long r118 = r17.onSurfaceVariant;
    L78:
        long r55 = r118;
        if ((r76 & 524288) == 0) goto L81;
        long r119 = r17.surfaceTint;
    L82:
        long r57 = r119;
        if ((r76 & 1048576) == 0) goto L85;
        long r120 = r17.inverseSurface;
    L86:
        long r59 = r120;
        if ((r76 & 2097152) == 0) goto L89;
        long r121 = r17.inverseOnSurface;
    L90:
        long r61 = r121;
        if ((r76 & 4194304) == 0) goto L93;
        long r122 = r17.error;
    L94:
        long r63 = r122;
        if ((r76 & 8388608) == 0) goto L97;
        long r123 = r17.onError;
    L98:
        long r65 = r123;
        if ((r76 & 16777216) == 0) goto L101;
        long r124 = r17.errorContainer;
    L102:
        long r67 = r124;
        if ((r76 & 33554432) == 0) goto L105;
        long r125 = r17.onErrorContainer;
    L106:
        long r69 = r125;
        if ((r76 & 67108864) == 0) goto L109;
        long r126 = r17.outline;
    L110:
        long r71 = r126;
        if ((r76 & 134217728) == 0) goto L113;
        long r127 = r17.outlineVariant;
    L114:
        long r73 = r127;
        if ((r76 & 268435456) == 0) goto L117;
        long r128 = r17.scrim;
    L119:
        return r17.m2444copyG1PFcw(r2, r4, r6, r8, r10, r12, r31, r33, r35, r37, r39, r41, r43, r45, r47, r49, r51, r53, r55, r57, r59, r61, r63, r65, r67, r69, r71, r73, r128);
    L117:
        r128 = r74;
        goto L119
    L113:
        r127 = r72;
        goto L114
    L109:
        r126 = r70;
        goto L110
    L105:
        r125 = r68;
        goto L106
    L101:
        r124 = r66;
        goto L102
    L97:
        r123 = r64;
        goto L98
    L93:
        r122 = r62;
        goto L94
    L89:
        r121 = r60;
        goto L90
    L85:
        r120 = r58;
        goto L86
    L81:
        r119 = r56;
        goto L82
    L77:
        r118 = r54;
        goto L78
    L73:
        r117 = r52;
        goto L74
    L69:
        r116 = r50;
        goto L70
    L65:
        r115 = r48;
        goto L66
    L61:
        r114 = r46;
        goto L62
    L57:
        r113 = r44;
        goto L58
    L53:
        r112 = r42;
        goto L54
    L49:
        r111 = r40;
        goto L50
    L45:
        r110 = r38;
        goto L46
    L41:
        r19 = r36;
        goto L42
    L37:
        r16 = r34;
        goto L38
    L33:
        r15 = r32;
        goto L34
    L29:
        r14 = r30;
        goto L30
    L25:
        r12 = r28;
        goto L27
    L21:
        r10 = r26;
        goto L23
    L17:
        r8 = r24;
        goto L19
    L13:
        r6 = r22;
        goto L15
    L9:
        r4 = r20;
        goto L11
    L5:
        r2 = r18;
        goto L7
    }

    private ColorScheme(long r99, long r101, long r103, long r105, long r107, long r109, long r111, long r113, long r115, long r117, long r119, long r121, long r123, long r125, long r127, long r129, long r131, long r133, long r135, long r137, long r139, long r141, long r143, long r145, long r147, long r149, long r151, long r153, long r155, long r157, long r159, long r161, long r163, long r165, long r167, long r169) {
        Color.Companion r95 = Color.Companion;
        this(r99, r101, r103, r105, r107, r109, r111, r113, r115, r117, r119, r121, r123, r125, r127, r129, r131, r133, r135, r137, r139, r141, r143, r145, r147, r149, r151, r153, r155, r157, r159, r161, r163, r165, r167, r169, r95.getUnspecified-0d7_KjU(), r95.getUnspecified-0d7_KjU(), r95.getUnspecified-0d7_KjU(), r95.getUnspecified-0d7_KjU(), r95.getUnspecified-0d7_KjU(), r95.getUnspecified-0d7_KjU(), r95.getUnspecified-0d7_KjU(), r95.getUnspecified-0d7_KjU(), r95.getUnspecified-0d7_KjU(), r95.getUnspecified-0d7_KjU(), r95.getUnspecified-0d7_KjU(), r95.getUnspecified-0d7_KjU(), null);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility. Use overload with additional fixed roles instead")
    /* JADX INFO: renamed from: copy-C-Xl9yA, reason: not valid java name */
    public final /* synthetic */ ColorScheme m2443copyCXl9yA(long r101, long r103, long r105, long r107, long r109, long r111, long r113, long r115, long r117, long r119, long r121, long r123, long r125, long r127, long r129, long r131, long r133, long r135, long r137, long r139, long r141, long r143, long r145, long r147, long r149, long r151, long r153, long r155, long r157, long r159, long r161, long r163, long r165, long r167, long r169, long r171) {
        return m2442copy_VG5OTI$default(this, r101, r103, r105, r107, r109, r111, r113, r115, r117, r119, r121, r123, r125, r127, r129, r131, r133, r135, r137, r139, r141, r143, r145, r147, r149, r151, r153, r155, r157, r159, r161, r163, r165, r167, r169, r171, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 65520, null);
    }

    /* JADX INFO: renamed from: copy-C-Xl9yA$default, reason: not valid java name */
    public static /* synthetic */ ColorScheme m2440copyCXl9yA$default(ColorScheme r17, long r18, long r20, long r22, long r24, long r26, long r28, long r30, long r32, long r34, long r36, long r38, long r40, long r42, long r44, long r46, long r48, long r50, long r52, long r54, long r56, long r58, long r60, long r62, long r64, long r66, long r68, long r70, long r72, long r74, long r76, long r78, long r80, long r82, long r84, long r86, long r88, int r90, int r91, Object r92) {
        if ((r90 & 1) == 0) goto L5;
        long r2 = r17.primary;
    L7:
        if ((r90 & 2) == 0) goto L9;
        long r4 = r17.onPrimary;
    L11:
        if ((r90 & 4) == 0) goto L13;
        long r6 = r17.primaryContainer;
    L15:
        if ((r90 & 8) == 0) goto L17;
        long r8 = r17.onPrimaryContainer;
    L19:
        if ((r90 & 16) == 0) goto L21;
        long r10 = r17.inversePrimary;
    L23:
        if ((r90 & 32) == 0) goto L25;
        long r12 = r17.secondary;
    L27:
        if ((r90 & 64) == 0) goto L29;
        long r14 = r17.onSecondary;
    L30:
        long r31 = r14;
        if ((r90 & 128) == 0) goto L33;
        long r15 = r17.secondaryContainer;
    L34:
        long r33 = r15;
        if ((r90 & 256) == 0) goto L37;
        long r16 = r17.onSecondaryContainer;
    L38:
        long r35 = r16;
        if ((r90 & 512) == 0) goto L41;
        long r19 = r17.tertiary;
    L42:
        long r37 = r19;
        if ((r90 & 1024) == 0) goto L45;
        long r110 = r17.onTertiary;
    L46:
        long r39 = r110;
        if ((r90 & 2048) == 0) goto L49;
        long r111 = r17.tertiaryContainer;
    L50:
        long r41 = r111;
        if ((r90 & 4096) == 0) goto L53;
        long r112 = r17.onTertiaryContainer;
    L54:
        long r43 = r112;
        if ((r90 & 8192) == 0) goto L57;
        long r113 = r17.background;
    L58:
        long r45 = r113;
        if ((r90 & 16384) == 0) goto L61;
        long r114 = r17.onBackground;
    L62:
        long r47 = r114;
        if ((r90 & BiometricManager$Authenticators.DEVICE_CREDENTIAL) == 0) goto L65;
        long r115 = r17.surface;
    L66:
        long r49 = r115;
        if ((r90 & 65536) == 0) goto L69;
        long r116 = r17.onSurface;
    L70:
        long r51 = r116;
        if ((r90 & 131072) == 0) goto L73;
        long r117 = r17.surfaceVariant;
    L74:
        long r53 = r117;
        if ((r90 & 262144) == 0) goto L77;
        long r118 = r17.onSurfaceVariant;
    L78:
        long r55 = r118;
        if ((r90 & 524288) == 0) goto L81;
        long r119 = r17.surfaceTint;
    L82:
        long r57 = r119;
        if ((r90 & 1048576) == 0) goto L85;
        long r120 = r17.inverseSurface;
    L86:
        long r59 = r120;
        if ((r90 & 2097152) == 0) goto L89;
        long r121 = r17.inverseOnSurface;
    L90:
        long r61 = r121;
        if ((r90 & 4194304) == 0) goto L93;
        long r122 = r17.error;
    L94:
        long r63 = r122;
        if ((r90 & 8388608) == 0) goto L97;
        long r123 = r17.onError;
    L98:
        long r65 = r123;
        if ((r90 & 16777216) == 0) goto L101;
        long r124 = r17.errorContainer;
    L102:
        long r67 = r124;
        if ((r90 & 33554432) == 0) goto L105;
        long r125 = r17.onErrorContainer;
    L106:
        long r69 = r125;
        if ((r90 & 67108864) == 0) goto L109;
        long r126 = r17.outline;
    L110:
        long r71 = r126;
        if ((r90 & 134217728) == 0) goto L113;
        long r127 = r17.outlineVariant;
    L114:
        long r73 = r127;
        if ((r90 & 268435456) == 0) goto L117;
        long r128 = r17.scrim;
    L118:
        long r75 = r128;
        if ((r90 & 536870912) == 0) goto L121;
        long r129 = r17.surfaceBright;
    L122:
        long r77 = r129;
        if ((r90 & 1073741824) == 0) goto L125;
        long r130 = r17.surfaceDim;
    L126:
        long r79 = r130;
        if ((r90 & RtlSpacingHelper.UNDEFINED) == 0) goto L129;
        long r131 = r17.surfaceContainer;
    L130:
        long r81 = r131;
        if ((r91 & 1) == 0) goto L133;
        long r132 = r17.surfaceContainerHigh;
    L134:
        long r83 = r132;
        if ((r91 & 2) == 0) goto L137;
        long r133 = r17.surfaceContainerHighest;
    L138:
        long r85 = r133;
        if ((r91 & 4) == 0) goto L141;
        long r134 = r17.surfaceContainerLow;
    L142:
        long r87 = r134;
        if ((r91 & 8) == 0) goto L145;
        long r135 = r17.surfaceContainerLowest;
    L147:
        return r17.m2443copyCXl9yA(r2, r4, r6, r8, r10, r12, r31, r33, r35, r37, r39, r41, r43, r45, r47, r49, r51, r53, r55, r57, r59, r61, r63, r65, r67, r69, r71, r73, r75, r77, r79, r81, r83, r85, r87, r135);
    L145:
        r135 = r88;
        goto L147
    L141:
        r134 = r86;
        goto L142
    L137:
        r133 = r84;
        goto L138
    L133:
        r132 = r82;
        goto L134
    L129:
        r131 = r80;
        goto L130
    L125:
        r130 = r78;
        goto L126
    L121:
        r129 = r76;
        goto L122
    L117:
        r128 = r74;
        goto L118
    L113:
        r127 = r72;
        goto L114
    L109:
        r126 = r70;
        goto L110
    L105:
        r125 = r68;
        goto L106
    L101:
        r124 = r66;
        goto L102
    L97:
        r123 = r64;
        goto L98
    L93:
        r122 = r62;
        goto L94
    L89:
        r121 = r60;
        goto L90
    L85:
        r120 = r58;
        goto L86
    L81:
        r119 = r56;
        goto L82
    L77:
        r118 = r54;
        goto L78
    L73:
        r117 = r52;
        goto L74
    L69:
        r116 = r50;
        goto L70
    L65:
        r115 = r48;
        goto L66
    L61:
        r114 = r46;
        goto L62
    L57:
        r113 = r44;
        goto L58
    L53:
        r112 = r42;
        goto L54
    L49:
        r111 = r40;
        goto L50
    L45:
        r110 = r38;
        goto L46
    L41:
        r19 = r36;
        goto L42
    L37:
        r16 = r34;
        goto L38
    L33:
        r15 = r32;
        goto L34
    L29:
        r14 = r30;
        goto L30
    L25:
        r12 = r28;
        goto L27
    L21:
        r10 = r26;
        goto L23
    L17:
        r8 = r24;
        goto L19
    L13:
        r6 = r22;
        goto L15
    L9:
        r4 = r20;
        goto L11
    L5:
        r2 = r18;
        goto L7
    }

    private ColorScheme(long r4, long r6, long r8, long r10, long r12, long r14, long r16, long r18, long r20, long r22, long r24, long r26, long r28, long r30, long r32, long r34, long r36, long r38, long r40, long r42, long r44, long r46, long r48, long r50, long r52, long r54, long r56, long r58, long r60, long r62, long r64, long r66, long r68, long r70, long r72, long r74, long r76, long r78, long r80, long r82, long r84, long r86, long r88, long r90, long r92, long r94, long r96, long r98) {
        this.primary = r4;
        this.onPrimary = r6;
        this.primaryContainer = r8;
        this.onPrimaryContainer = r10;
        this.inversePrimary = r12;
        this.secondary = r14;
        this.onSecondary = r16;
        this.secondaryContainer = r18;
        this.onSecondaryContainer = r20;
        this.tertiary = r22;
        this.onTertiary = r24;
        this.tertiaryContainer = r26;
        this.onTertiaryContainer = r28;
        this.background = r30;
        this.onBackground = r32;
        this.surface = r34;
        this.onSurface = r36;
        this.surfaceVariant = r38;
        this.onSurfaceVariant = r40;
        this.surfaceTint = r42;
        this.inverseSurface = r44;
        this.inverseOnSurface = r46;
        this.error = r48;
        this.onError = r50;
        this.errorContainer = r52;
        this.onErrorContainer = r54;
        this.outline = r56;
        this.outlineVariant = r58;
        this.scrim = r60;
        this.surfaceBright = r62;
        this.surfaceDim = r64;
        this.surfaceContainer = r66;
        this.surfaceContainerHigh = r68;
        this.surfaceContainerHighest = r70;
        this.surfaceContainerLow = r72;
        this.surfaceContainerLowest = r74;
        this.primaryFixed = r76;
        this.primaryFixedDim = r78;
        this.onPrimaryFixed = r80;
        this.onPrimaryFixedVariant = r82;
        this.secondaryFixed = r84;
        this.secondaryFixedDim = r86;
        this.onSecondaryFixed = r88;
        this.onSecondaryFixedVariant = r90;
        this.tertiaryFixed = r92;
        this.tertiaryFixedDim = r94;
        this.onTertiaryFixed = r96;
        this.onTertiaryFixedVariant = r98;
    }

    /* JADX INFO: renamed from: copy-_VG5OTI, reason: not valid java name */
    public final ColorScheme m2445copy_VG5OTI(long r100, long r102, long r104, long r106, long r108, long r110, long r112, long r114, long r116, long r118, long r120, long r122, long r124, long r126, long r128, long r130, long r132, long r134, long r136, long r138, long r140, long r142, long r144, long r146, long r148, long r150, long r152, long r154, long r156, long r158, long r160, long r162, long r164, long r166, long r168, long r170, long r172, long r174, long r176, long r178, long r180, long r182, long r184, long r186, long r188, long r190, long r192, long r194) {
        return new ColorScheme(r100, r102, r104, r106, r108, r110, r112, r114, r116, r118, r120, r122, r124, r126, r128, r130, r132, r134, r136, r138, r140, r142, r144, r146, r148, r150, r152, r154, r156, r158, r160, r162, r164, r166, r168, r170, r172, r174, r176, r178, r180, r182, r184, r186, r188, r190, r192, r194, null);
    }

    /* JADX INFO: renamed from: copy-_VG5OTI$default, reason: not valid java name */
    public static /* synthetic */ ColorScheme m2442copy_VG5OTI$default(ColorScheme r17, long r18, long r20, long r22, long r24, long r26, long r28, long r30, long r32, long r34, long r36, long r38, long r40, long r42, long r44, long r46, long r48, long r50, long r52, long r54, long r56, long r58, long r60, long r62, long r64, long r66, long r68, long r70, long r72, long r74, long r76, long r78, long r80, long r82, long r84, long r86, long r88, long r90, long r92, long r94, long r96, long r98, long r100, long r102, long r104, long r106, long r108, long r110, long r112, int r114, int r115, Object r116) {
        if ((r114 & 1) == 0) goto L5;
        long r3 = r17.primary;
    L7:
        if ((r114 & 2) == 0) goto L9;
        long r5 = r17.onPrimary;
    L11:
        if ((r114 & 4) == 0) goto L13;
        long r7 = r17.primaryContainer;
    L15:
        if ((r114 & 8) == 0) goto L17;
        long r9 = r17.onPrimaryContainer;
    L19:
        if ((r114 & 16) == 0) goto L21;
        long r11 = r17.inversePrimary;
    L23:
        if ((r114 & 32) == 0) goto L25;
        long r13 = r17.secondary;
    L26:
        long r29 = r13;
        if ((r114 & 64) == 0) goto L29;
        long r14 = r17.onSecondary;
    L30:
        long r31 = r14;
        if ((r114 & 128) == 0) goto L33;
        long r15 = r17.secondaryContainer;
    L34:
        long r33 = r15;
        if ((r114 & 256) == 0) goto L37;
        long r16 = r17.onSecondaryContainer;
    L38:
        long r35 = r16;
        if ((r114 & 512) == 0) goto L41;
        long r19 = r17.tertiary;
    L42:
        long r37 = r19;
        if ((r114 & 1024) == 0) goto L45;
        long r111 = r17.onTertiary;
    L46:
        long r39 = r111;
        if ((r114 & 2048) == 0) goto L49;
        long r113 = r17.tertiaryContainer;
    L50:
        long r41 = r113;
        if ((r114 & 4096) == 0) goto L53;
        long r117 = r17.onTertiaryContainer;
    L54:
        long r43 = r117;
        if ((r114 & 8192) == 0) goto L57;
        long r118 = r17.background;
    L58:
        long r45 = r118;
        if ((r114 & 16384) == 0) goto L61;
        long r119 = r17.onBackground;
    L62:
        long r47 = r119;
        if ((r114 & BiometricManager$Authenticators.DEVICE_CREDENTIAL) == 0) goto L65;
        long r120 = r17.surface;
    L66:
        long r49 = r120;
        if ((r114 & 65536) == 0) goto L69;
        long r121 = r17.onSurface;
    L70:
        long r51 = r121;
        if ((r114 & 131072) == 0) goto L73;
        long r122 = r17.surfaceVariant;
    L74:
        long r53 = r122;
        if ((r114 & 262144) == 0) goto L77;
        long r123 = r17.onSurfaceVariant;
    L78:
        long r55 = r123;
        if ((r114 & 524288) == 0) goto L81;
        long r124 = r17.surfaceTint;
    L82:
        long r57 = r124;
        if ((r114 & 1048576) == 0) goto L85;
        long r125 = r17.inverseSurface;
    L86:
        long r59 = r125;
        if ((r114 & 2097152) == 0) goto L89;
        long r126 = r17.inverseOnSurface;
    L90:
        long r61 = r126;
        if ((r114 & 4194304) == 0) goto L93;
        long r127 = r17.error;
    L94:
        long r63 = r127;
        if ((r114 & 8388608) == 0) goto L97;
        long r128 = r17.onError;
    L98:
        long r65 = r128;
        if ((r114 & 16777216) == 0) goto L101;
        long r129 = r17.errorContainer;
    L102:
        long r67 = r129;
        if ((r114 & 33554432) == 0) goto L105;
        long r130 = r17.onErrorContainer;
    L106:
        long r69 = r130;
        if ((r114 & 67108864) == 0) goto L109;
        long r131 = r17.outline;
    L110:
        long r71 = r131;
        if ((r114 & 134217728) == 0) goto L113;
        long r132 = r17.outlineVariant;
    L114:
        long r73 = r132;
        if ((r114 & 268435456) == 0) goto L117;
        long r133 = r17.scrim;
    L118:
        long r75 = r133;
        if ((r114 & 536870912) == 0) goto L121;
        long r134 = r17.surfaceBright;
    L122:
        long r77 = r134;
        if ((r114 & 1073741824) == 0) goto L125;
        long r135 = r17.surfaceDim;
    L126:
        long r79 = r135;
        if ((r114 & RtlSpacingHelper.UNDEFINED) == 0) goto L129;
        long r136 = r17.surfaceContainer;
    L130:
        long r81 = r136;
        if ((r115 & 1) == 0) goto L133;
        long r137 = r17.surfaceContainerHigh;
    L134:
        long r83 = r137;
        if ((r115 & 2) == 0) goto L137;
        long r138 = r17.surfaceContainerHighest;
    L138:
        long r85 = r138;
        if ((r115 & 4) == 0) goto L141;
        long r139 = r17.surfaceContainerLow;
    L142:
        long r87 = r139;
        if ((r115 & 8) == 0) goto L145;
        long r140 = r17.surfaceContainerLowest;
    L146:
        long r89 = r140;
        if ((r115 & 16) == 0) goto L149;
        long r141 = r17.primaryFixed;
    L150:
        long r91 = r141;
        if ((r115 & 32) == 0) goto L153;
        long r142 = r17.primaryFixedDim;
    L154:
        long r93 = r142;
        if ((r115 & 64) == 0) goto L157;
        long r143 = r17.onPrimaryFixed;
    L158:
        long r95 = r143;
        if ((r115 & 128) == 0) goto L161;
        long r144 = r17.onPrimaryFixedVariant;
    L162:
        long r97 = r144;
        if ((r115 & 256) == 0) goto L165;
        long r145 = r17.secondaryFixed;
    L166:
        long r99 = r145;
        if ((r115 & 512) == 0) goto L169;
        long r146 = r17.secondaryFixedDim;
    L170:
        long r101 = r146;
        if ((r115 & 1024) == 0) goto L173;
        long r147 = r17.onSecondaryFixed;
    L174:
        long r103 = r147;
        if ((r115 & 2048) == 0) goto L177;
        long r148 = r17.onSecondaryFixedVariant;
    L178:
        long r105 = r148;
        if ((r115 & 4096) == 0) goto L181;
        long r149 = r17.tertiaryFixed;
    L182:
        long r107 = r149;
        if ((r115 & 8192) == 0) goto L185;
        long r150 = r17.tertiaryFixedDim;
    L186:
        long r109 = r150;
        if ((r115 & 16384) == 0) goto L189;
        long r151 = r17.onTertiaryFixed;
    L191:
        if ((r115 & BiometricManager$Authenticators.DEVICE_CREDENTIAL) == 0) goto L193;
        long r1 = r17.onTertiaryFixedVariant;
    L195:
        return r17.m2445copy_VG5OTI(r3, r5, r7, r9, r11, r29, r31, r33, r35, r37, r39, r41, r43, r45, r47, r49, r51, r53, r55, r57, r59, r61, r63, r65, r67, r69, r71, r73, r75, r77, r79, r81, r83, r85, r87, r89, r91, r93, r95, r97, r99, r101, r103, r105, r107, r109, r151, r1);
    L193:
        r1 = r112;
        goto L195
    L189:
        r151 = r110;
        goto L191
    L185:
        r150 = r108;
        goto L186
    L181:
        r149 = r106;
        goto L182
    L177:
        r148 = r104;
        goto L178
    L173:
        r147 = r102;
        goto L174
    L169:
        r146 = r100;
        goto L170
    L165:
        r145 = r98;
        goto L166
    L161:
        r144 = r96;
        goto L162
    L157:
        r143 = r94;
        goto L158
    L153:
        r142 = r92;
        goto L154
    L149:
        r141 = r90;
        goto L150
    L145:
        r140 = r88;
        goto L146
    L141:
        r139 = r86;
        goto L142
    L137:
        r138 = r84;
        goto L138
    L133:
        r137 = r82;
        goto L134
    L129:
        r136 = r80;
        goto L130
    L125:
        r135 = r78;
        goto L126
    L121:
        r134 = r76;
        goto L122
    L117:
        r133 = r74;
        goto L118
    L113:
        r132 = r72;
        goto L114
    L109:
        r131 = r70;
        goto L110
    L105:
        r130 = r68;
        goto L106
    L101:
        r129 = r66;
        goto L102
    L97:
        r128 = r64;
        goto L98
    L93:
        r127 = r62;
        goto L94
    L89:
        r126 = r60;
        goto L90
    L85:
        r125 = r58;
        goto L86
    L81:
        r124 = r56;
        goto L82
    L77:
        r123 = r54;
        goto L78
    L73:
        r122 = r52;
        goto L74
    L69:
        r121 = r50;
        goto L70
    L65:
        r120 = r48;
        goto L66
    L61:
        r119 = r46;
        goto L62
    L57:
        r118 = r44;
        goto L58
    L53:
        r117 = r42;
        goto L54
    L49:
        r113 = r40;
        goto L50
    L45:
        r111 = r38;
        goto L46
    L41:
        r19 = r36;
        goto L42
    L37:
        r16 = r34;
        goto L38
    L33:
        r15 = r32;
        goto L34
    L29:
        r14 = r30;
        goto L30
    L25:
        r13 = r28;
        goto L26
    L21:
        r11 = r26;
        goto L23
    L17:
        r9 = r24;
        goto L19
    L13:
        r7 = r22;
        goto L15
    L9:
        r5 = r20;
        goto L11
    L5:
        r3 = r18;
        goto L7
    }
}
