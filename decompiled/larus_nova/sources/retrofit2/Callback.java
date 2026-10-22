package retrofit2;

/* JADX INFO: loaded from: classes41.dex */
public interface Callback<T> {
    void onFailure(Call<T> r100, Throwable r101);

    void onResponse(Call<T> r100, Response<T> r101);
}
