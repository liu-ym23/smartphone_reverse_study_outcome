package androidx.camera.video.internal.audio;

import android.content.Context;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
interface AudioStreamFactory {
    AudioStream create(AudioSettings r1, Context r2) throws AudioStream.AudioStreamException;
}
