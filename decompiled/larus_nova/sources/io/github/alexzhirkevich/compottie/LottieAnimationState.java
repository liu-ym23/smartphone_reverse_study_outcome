package io.github.alexzhirkevich.compottie;

import androidx.compose.runtime.State;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes41.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001R\u0012\u0010\u0003\u001a\u00020\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0002X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0012\u0010\t\u001a\u00020\nX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0012\u0010\r\u001a\u00020\nX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\fR\u0012\u0010\u000f\u001a\u00020\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0005R\u0014\u0010\u0011\u001a\u0004\u0018\u00010\u0012X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u0012\u0010\u0015\u001a\u00020\u0002X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\bR\u0012\u0010\u0017\u001a\u00020\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0005R\u0014\u0010\u0019\u001a\u0004\u0018\u00010\u001aX¦\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR\u0014\u0010\u001d\u001a\u00020\u001e8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010 R\u0012\u0010!\u001a\u00020\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\u0005¨\u0006\""}, d2 = {"Lio/github/alexzhirkevich/compottie/LottieAnimationState;", "Landroidx/compose/runtime/State;", "", "isPlaying", "", "()Z", "progress", "getProgress", "()F", "iteration", "", "getIteration", "()I", "iterations", "getIterations", "reverseOnRepeat", "getReverseOnRepeat", "clipSpec", "Lio/github/alexzhirkevich/compottie/LottieClipSpec;", "getClipSpec", "()Lio/github/alexzhirkevich/compottie/LottieClipSpec;", "speed", "getSpeed", "useCompositionFrameRate", "getUseCompositionFrameRate", "composition", "Lio/github/alexzhirkevich/compottie/LottieComposition;", "getComposition", "()Lio/github/alexzhirkevich/compottie/LottieComposition;", "lastFrameNanos", "", "getLastFrameNanos", "()J", "isAtEnd", "compottie_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface LottieAnimationState extends State<Float> {
    int b();

    k d();

    LottieComposition getComposition();

    float getProgress();

    float getSpeed();
}
